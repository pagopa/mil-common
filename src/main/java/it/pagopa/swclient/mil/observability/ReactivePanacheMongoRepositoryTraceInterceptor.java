/*
 * ReactivePanacheMongoRepositoryTraceInterceptor.java
 *
 * 29 apr 2024
 */
package it.pagopa.swclient.mil.observability;

import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.microprofile.config.ConfigProvider;

import com.mongodb.MongoNamespace;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import io.quarkus.logging.Log;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepositoryBase;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

/**
 * This class implements the logic to trace with OpenTelemetry standard the invocations to classes
 * which implements io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepositoryBase
 * interface.
 * 
 * @author Antonio Tarricone
 */
@TraceReactivePanacheMongoRepository
@Interceptor
public class ReactivePanacheMongoRepositoryTraceInterceptor {
	/*
	 * 
	 */
	private Tracer tracer;

	/*
	 * Methods of io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepositoryBase that must not
	 * be traced.
	 */
	private List<String> methodsToIgnore;

	/**
	 * Constructor.
	 * 
	 * @param tracer
	 */
	@Inject
	ReactivePanacheMongoRepositoryTraceInterceptor(Tracer tracer) {
		this.tracer = tracer;
		methodsToIgnore = List.of("mongoCollection", "mongoDatabase");
	}

	/**
	 * This method implements the tracing logic.
	 * 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	@AroundInvoke
	Object trace(InvocationContext context) throws Exception {
		try {
			ReactivePanacheMongoRepositoryBase<?, ?> repository = (ReactivePanacheMongoRepositoryBase<?, ?>) (context.getTarget());

			Class<?> clazz = context.getTarget().getClass();
			Method method = context.getMethod();
			Log.debugf("Intercepted method: %s", method.toString());

			if (!methodsToIgnore.contains(method.getName())) {
				ReactiveMongoCollection<?> mongoCollection = repository.mongoCollection();

				/*
				 * Resolving connection string.
				 */
				Class<?> documentClass = mongoCollection.getDocumentClass();
				MongoEntity mongoEntity = documentClass.getAnnotation(MongoEntity.class);

				String clientName = null;
				if (mongoEntity != null) {
					clientName = mongoEntity.clientName();
				}

				String connectionString = null;
				if (clientName == null || clientName.isEmpty()) {
					connectionString = ConfigProvider.getConfig().getOptionalValue("quarkus.mongodb.connection-string", String.class).orElse(null);
				} else {
					connectionString = ConfigProvider.getConfig().getOptionalValue(String.format("quarkus.mongodb.%s.connection-string", clientName), String.class).orElse(null);
					/*
					 * If connectionString is null the MongoClient cannot be created by Quarkus, so this point would be
					 * not reachable!
					 */
				}

				/*
				 * Build and start span.
				 */
				MongoNamespace mongoNamespace = mongoCollection.getNamespace();
				Span span = tracer.spanBuilder(clazz.getSimpleName() + "." + method.getName())
					.setParent(Context.current().with(Span.current()))
					.setSpanKind(SpanKind.CLIENT)
					.setAttribute("db.system", "mongodb")
					.setAttribute("db.operation", method.getName())
					.setAttribute("db.name", mongoNamespace.getDatabaseName())
					.setAttribute("db.mongodb.collection", mongoNamespace.getCollectionName())
					.setAttribute("db.connection_string", connectionString != null ? connectionString : "")
					.startSpan();

				/*
				 * Proceed with the intercepted invocation.
				 */
				Object ret = null;
				try {
					ret = context.proceed();
				} finally {
					/*
					 * End span.
					 */
					span.end();
				}

				/*
				 * Finish!
				 */
				return ret;
			} else {
				Log.infof("The method %s must not be traced!", method);
				return context.proceed();
			}
		} catch (ClassCastException e) {
			Log.warn("Did you use @TraceReactivePanacheMongoRepository with a class which doesn't implement io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepositoryBase?");
			return context.proceed();
		}
	}
}
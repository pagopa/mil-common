/*
 * Trace.java
 *
 * 22 apr 2024
 */
package it.pagopa.swclient.mil.observability;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.interceptor.InterceptorBinding;

/**
 * <p>
 * Annotation to mark the classes which implement
 * {@link io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepositoryBase} that must be
 * traced.
 * </p>
 * <p>
 * {@code io.quarkus:quarkus-opentelemetry} must be added among the dependencies.
 * </p>
 *
 * @author Antonio Tarricone
 */
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({
	ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR
})
@Inherited
public @interface TraceReactivePanacheMongoRepository {
}
/*
 * ReactivePanacheMongoRepositoryTraceInterceptorTest.java
 *
 * 30 apr 2024
 */
package it.pagopa.swclient.mil.observability;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

/**
 * 
 * @author antonio.tarricone
 */
@QuarkusTest
class ReactivePanacheMongoRepositoryTraceInterceptorTest {
	/*
	 * 
	 */
	@Inject
	RepositoryWithoutClientName repositoryWithoutClientName;

	/*
	 * 
	 */
	@Inject
	RepositoryWithClientName repositoryWithClientName;

	/*
	 * 
	 */
	@Inject
	RepositoryWithoutAnnotation repositoryWithoutAnnotation;

	/*
	 * 
	 */
	private static OtelReceiver receiver;

	/**
	 * 
	 */
	@BeforeAll
	static void initOtel() {
		receiver = new OtelReceiver();
		GlobalOpenTelemetry.resetForTest();
		OpenTelemetrySdk.builder()
			.setTracerProvider(
				SdkTracerProvider.builder()
					.addSpanProcessor(SimpleSpanProcessor.create(receiver))
					.build())
			.buildAndRegisterGlobal();
	}

	/**
	 * 
	 */
	@Test
	void given_entityWithoutClientName_when_repositoryMethodIsInvoked_then_spanContainsCorrectAttributes() {
		EntityWithoutClientName entity = new EntityWithoutClientName();
		entity.id = ObjectId.get().toHexString();
		entity.attribute1 = "attribute1";
		entity.attribute2 = "attribute2";

		repositoryWithoutClientName.persist(entity).subscribe().with(item -> {
		}, failure -> {
		});

		Map<String, String> attributes = receiver.getAttributes();

		assertThat(attributes).containsExactlyInAnyOrderEntriesOf(Map.of("db.connection_string", "mongodb://localhost:27017",
			"db.system", "mongodb",
			"db.operation", "persist",
			"db.mongodb.collection", "test",
			"db.name", "swclient_mil_test"));
	}

	/**
	 * 
	 */
	@Test
	void given_entityWithClientName_when_repositoryMethodIsInvoked_then_spanContainsCorrectAttributes() {
		EntityWithClientName entity = new EntityWithClientName();
		entity.id = ObjectId.get().toHexString();
		entity.attribute1 = "attribute1";
		entity.attribute2 = "attribute2";

		repositoryWithClientName.persist(entity).subscribe().with(item -> {
		}, failure -> {
		});

		Map<String, String> attributes = receiver.getAttributes();

		assertThat(attributes).containsExactlyInAnyOrderEntriesOf(Map.of("db.connection_string", "mongodb://localhost:27018",
			"db.system", "mongodb",
			"db.operation", "persist",
			"db.mongodb.collection", "test",
			"db.name", "swclient_mil_test"));
	}

	/**
	 * 
	 */
	@Test
	void given_entityWithoutAnnotation_when_repositoryMethodIsInvoked_then_spanContainsCorrectAttributes() {
		EntityWithoutAnnotation entity = new EntityWithoutAnnotation();
		entity.id = ObjectId.get().toHexString();
		entity.attribute1 = "attribute1";
		entity.attribute2 = "attribute2";

		repositoryWithoutAnnotation.persist(entity).subscribe().with(item -> {
		}, failure -> {
		});

		Map<String, String> attributes = receiver.getAttributes();

		assertThat(attributes).containsExactlyInAnyOrderEntriesOf(Map.of("db.connection_string", "mongodb://localhost:27017",
			"db.system", "mongodb",
			"db.operation", "persist",
			"db.mongodb.collection", "EntityWithoutAnnotation",
			"db.name", "test_database"));
	}
}
/*
 * MappedDiagnosticContextFilterTest.java
 *
 * 29 apr 2024
 */
package it.pagopa.swclient.mil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.jboss.logging.MDC;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.container.ContainerRequestContext;

/**
 * 
 * @author antonio.tarricone
 */
@QuarkusTest
class MappedDiagnosticContextFilterTest {
	/**
	 * Test method for
	 * {@link it.pagopa.swclient.mil.MappedDiagnosticContextFilter#filter(jakarta.ws.rs.container.ContainerRequestContext)}.
	 * 
	 * @throws IOException
	 */
	@Test
	void given_request_when_requestIdIsNotNull_then_putItInMdc() throws IOException {
		ContainerRequestContext context = mock(ContainerRequestContext.class);
		when(context.getHeaderString("RequestId")).thenReturn("my-request-id");
		new MappedDiagnosticContextFilter().filter(context);

		assertEquals("my-request-id", MDC.get("requestId"));
	}

	/**
	 * Test method for
	 * {@link it.pagopa.swclient.mil.MappedDiagnosticContextFilter#filter(jakarta.ws.rs.container.ContainerRequestContext)}.
	 * 
	 * @throws IOException
	 */
	@Test
	void given_rRequest_when_requestIdIsNull_then_putNewOneInMdc() throws IOException {
		ContainerRequestContext context = mock(ContainerRequestContext.class);
		when(context.getHeaderString("RequestId")).thenReturn(null);
		new MappedDiagnosticContextFilter().filter(context);

		assertNotEquals("my-request-id", MDC.get("requestId"));
	}
}

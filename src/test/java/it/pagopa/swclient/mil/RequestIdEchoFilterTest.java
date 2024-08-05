/*
 * RequestIdEchoFilterTest.java
 *
 * 25 lug 2024
 */
package it.pagopa.swclient.mil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.core.MultivaluedHashMap;
import jakarta.ws.rs.core.MultivaluedMap;

/**
 * 
 * @author Antonio Tarricone
 */
@QuarkusTest
class RequestIdEchoFilterTest {
	/**
	 * Test method for
	 * {@link it.pagopa.swclient.mil.RequestIdEchoFilter#filter(jakarta.ws.rs.container.ContainerRequestContext, jakarta.ws.rs.container.ContainerResponseContext)}.
	 * 
	 * @throws IOException
	 */
	@Test
	void testFilter() throws IOException {
		ContainerRequestContext requestContext = mock(ContainerRequestContext.class);
		when(requestContext.getHeaderString("RequestId")).thenReturn("my-request-id");

		MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
		ContainerResponseContext responseContext = mock(ContainerResponseContext.class);
		when(responseContext.getHeaders()).thenReturn(headers);

		new RequestIdEchoFilter().filter(requestContext, responseContext);

		assertEquals(List.of("my-request-id"), headers.get("RequestId"));
	}
}

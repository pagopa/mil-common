/*
 * MappedDiagnosticContextFilter.java
 *
 * 28 nov 2022
 */
package it.pagopa.swclient.mil;

import java.io.IOException;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.ext.Provider;

import org.jboss.logging.MDC;

/**
 * 
 * @author Antonio Tarricone
 */
@Provider
@PreMatching
public class MappedDiagnosticContextFilter implements ContainerRequestFilter {
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String requestId = requestContext.getHeaderString("RequestId");
		if (requestId == null) {
			requestId = "n/a";
		}
		MDC.put("requestId", requestId);
	}
}

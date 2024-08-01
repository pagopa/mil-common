/*
 * MappedDiagnosticContextFilter.java
 *
 * 28 nov 2022
 */
package it.pagopa.swclient.mil;

import java.io.IOException;
import java.util.UUID;

import org.jboss.logging.MDC;

import it.pagopa.swclient.mil.bean.HeaderParamName;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.ext.Provider;

/**
 * 
 * @author Antonio Tarricone
 */
@Provider
@PreMatching
@Priority(Priorities.USER + 100)
public class MappedDiagnosticContextFilter implements ContainerRequestFilter {
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String requestId = requestContext.getHeaderString(HeaderParamName.REQUEST_ID);
		if (requestId == null) {
			requestId = UUID.randomUUID().toString();
			requestContext.getHeaders().add(HeaderParamName.REQUEST_ID, requestId);
		}
		MDC.put("requestId", requestId);
	}
}

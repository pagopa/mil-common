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
 * <p>
 * Generates a RequestId if any and stores it in the mapped diagnostic context for logging.
 * </p>
 * 
 * @author Antonio Tarricone
 */
@Provider
@PreMatching
@Priority(Priorities.USER + 100)
public class MappedDiagnosticContextFilter implements ContainerRequestFilter {
	/**
	 * <p>
	 * Default constructor.
	 * </p>
	 */
	public MappedDiagnosticContextFilter() {
		// Default constructor.
	}

	/**
	 * <p>
	 * Generates a RequestId if any and stores it in the mapped diagnostic context for logging.
	 * </p>
	 * 
	 * @see jakarta.ws.rs.container.ContainerRequestFilter#filter(ContainerRequestContext)
	 */
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

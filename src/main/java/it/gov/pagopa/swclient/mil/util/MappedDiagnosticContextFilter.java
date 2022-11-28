/*
 * MappedDiagnosticContextFilter.java
 *
 * 28 nov 2022
 */
package it.gov.pagopa.swclient.mil.util;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

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
			requestId = "null";
		}
	    MDC.put("requestId", requestId);  
	}
}

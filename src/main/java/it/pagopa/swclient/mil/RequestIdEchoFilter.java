/*
 * RequestIdEchoFilter.java
 *
 * 25 lug 2024
 */
package it.pagopa.swclient.mil;

import java.io.IOException;

import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

/**
 * Echoes the RequestId header from request to response.
 * 
 * @author Antonio Tarricone
 */
@Provider
@Priority(Priorities.USER)
public class RequestIdEchoFilter implements ContainerResponseFilter {
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		responseContext.getHeaders().add("RequestId", requestContext.getHeaderString("RequestId"));
	}
}

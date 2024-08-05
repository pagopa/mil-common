/*
 * RequestIdEchoFilter.java
 *
 * 25 lug 2024
 */
package it.pagopa.swclient.mil;

import java.io.IOException;

import it.pagopa.swclient.mil.bean.HeaderParamName;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

/**
 * <p>
 * Echoes the RequestId header from request to response.
 * </p>
 * 
 * @author Antonio Tarricone
 */
@Provider
@Priority(Priorities.USER)
public class RequestIdEchoFilter implements ContainerResponseFilter {
	/**
	 * <p>
	 * Default constructor.
	 * </p>
	 */
	public RequestIdEchoFilter() {
		// Default constructor.
	}
	
	/**
	 * <p>
	 * Echoes the RequestId header from request to response.
	 * </p>
	 * 
	 * @see jakarta.ws.rs.container.ContainerResponseFilter#filter(ContainerRequestContext,
	 *      ContainerResponseContext)
	 */
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		responseContext.getHeaders().add(HeaderParamName.REQUEST_ID, requestContext.getHeaderString(HeaderParamName.REQUEST_ID));
	}
}

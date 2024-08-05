/*
 * MappedDiagnosticContextFilter.java
 *
 * 28 nov 2022
 */
package it.pagopa.swclient.mil;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import it.pagopa.swclient.mil.bean.Errors;
import it.pagopa.swclient.mil.bean.HeaderParamName;
import it.pagopa.swclient.mil.bean.ValidationPattern;
import jakarta.annotation.Priority;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.Provider;

/**
 * <p>
 * Validates RequestId and Version headers if they are present.
 * </p>
 * 
 * @author Antonio Tarricone
 */
@Provider
@PreMatching
@Priority(Priorities.USER)
public class CommonHeadersValidatorFilter implements ContainerRequestFilter {
	/**
	 * <p>
	 * Default constructor.
	 * </p>
	 */
	public CommonHeadersValidatorFilter() {
		// Default constructor.
	}
	
	/**
	 * <p>
	 * Validates RequestId and Version headers if they are present.
	 * </p>
	 * 
	 * @see jakarta.ws.rs.container.ContainerRequestFilter#filter(ContainerRequestContext)
	 */
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		List<String> errorCodes = new LinkedList<>();
		List<String> errorMsgs = new LinkedList<>();

		String requestId = requestContext.getHeaderString(HeaderParamName.REQUEST_ID);
		if (requestId != null && !requestId.matches(ValidationPattern.REQUEST_ID)) {
			errorCodes.add(ErrorCode.REQUEST_ID_MUST_MATCH_REGEXP);
			errorCodes.add(ErrorCode.REQUEST_ID_MUST_MATCH_REGEXP_MSG);
		}

		String version = requestContext.getHeaderString(HeaderParamName.VERSION);
		if (version != null && !version.matches(ValidationPattern.VERSION)) {
			errorCodes.add(ErrorCode.VERSION_MUST_MATCH_REGEXP);
			errorCodes.add(ErrorCode.VERSION_MUST_MATCH_REGEXP_MSG);
		}

		if (!errorCodes.isEmpty()) {
			Response response = Response.status(Status.BAD_REQUEST)
				.entity(new Errors(errorCodes, errorMsgs))
				.build();
			throw new BadRequestException(response);
		}
	}
}
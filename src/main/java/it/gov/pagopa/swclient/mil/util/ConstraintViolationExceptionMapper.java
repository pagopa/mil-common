/*
 * ConstraintViolationExceptionMapper.java
 * 
 * 26 nov 2022
 */
package it.gov.pagopa.swclient.mil.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import io.quarkus.logging.Log;
import it.gov.pagopa.swclient.mil.dto.Errors;

/**
 * Normalize the body of Constraint Violation Exception (BAD REQUEST) handled directly by Quarkus
 * 
 * @author Antonio Tarricone
 */
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
	/**
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(Throwable)
	 */
	public Response toResponse(ConstraintViolationException e) {
		List<String> errorCodes = e.getConstraintViolations().stream()
			.map(c -> {
				String message = c.getMessage();
				Log.error(message);

				Pattern pattern = Pattern.compile("\\[(.*?)\\]");
				Matcher matcher = pattern.matcher(message);
				String errorCode = null;
				if (matcher.find()) {
					errorCode = matcher.group(1);
				} else {
					errorCode = "";
				}
				return errorCode;
			})
			.toList();

		return Response
			.status(Response.Status.BAD_REQUEST.getStatusCode())
			.entity(new Errors(errorCodes))
			.build();
	}
}

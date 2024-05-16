/*
 * ConstraintViolationExceptionMapper.java
 * 
 * 26 nov 2022
 */
package it.pagopa.swclient.mil;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import io.quarkus.logging.Log;
import it.pagopa.swclient.mil.bean.Errors;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>Normalize the body of Constraint Violation Exception (BAD REQUEST) handled directly by Quarkus.</p>
 * 
 * @author Antonio Tarricone
 */
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
	/*
	 * 
	 */
	@AllArgsConstructor
	@Getter
	private class Error {
		private String code;
		private String description;
	}

	/**
	 * @see jakarta.ws.rs.ext.ExceptionMapper#toResponse(Throwable)
	 */
	public Response toResponse(ConstraintViolationException e) {
		Log.debugf(e, "Exception to map");
		Map<String, String> errors = e.getConstraintViolations().stream()
			.map(c -> {
				String message = c.getMessage();
				Log.debugf("Message to parse: %s", message);

				Pattern pattern = Pattern.compile("\\[(.*?)\\]");
				Matcher matcher = pattern.matcher(message);
				String errorCode = null;
				if (matcher.find()) {
					errorCode = matcher.group(1);
				} else {
					Log.warnf("Message %s doesn't contain error code", message);
					errorCode = "";
				}
				return new Error(errorCode, message);
			})
			.collect(Collectors.toMap(Error::getCode, Error::getDescription, (value1, value2) -> value1));

		return Response
			.status(Response.Status.BAD_REQUEST.getStatusCode())
			.entity(new Errors(
				errors.keySet().stream().toList(),
				errors.values().stream().toList()))
			.build();
	}
}

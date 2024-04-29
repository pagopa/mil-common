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

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import io.quarkus.logging.Log;
import it.pagopa.swclient.mil.bean.Errors;

/**
 * Normalize the body of Constraint Violation Exception (BAD REQUEST) handled directly by Quarkus.
 * 
 * @author Antonio Tarricone
 */
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
	/*
	 * 
	 */
	@ConfigProperty(name = "returnRawConstraintViolationDescription", defaultValue = "false")
	boolean returnRawConstraintViolationDescription;

	/**
	 * 
	 */
	private class Error {
		/*
		 * 
		 */
		private String code;

		/*
		 * 
		 */
		private String description;

		/**
		 * @param code
		 * @param description
		 */
		public Error(String code, String description) {
			this.code = code;
			this.description = description;
		}

		/**
		 * @return the code
		 */
		public String getCode() {
			return code;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}
	}

	/**
	 * @see jakarta.ws.rs.ext.ExceptionMapper#toResponse(Throwable)
	 */
	public Response toResponse(ConstraintViolationException e) {
		Map<String, String> errors = e.getConstraintViolations().stream()
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
				return new Error(errorCode, message);
			})
			.collect(Collectors.toMap(Error::getCode, Error::getDescription, (value1, value2) -> value1));

		if (returnRawConstraintViolationDescription) {
			errors.put("orig", e.toString());
		}

		return Response
			.status(Response.Status.BAD_REQUEST.getStatusCode())
			.entity(new Errors(
				errors.keySet().stream().toList(),
				errors.values().stream().toList()))
			.build();
	}
}

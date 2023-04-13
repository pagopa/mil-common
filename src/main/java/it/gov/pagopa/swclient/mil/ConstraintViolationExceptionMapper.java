/*
 * ConstraintViolationExceptionMapper.java
 * 
 * 26 nov 2022
 */
package it.gov.pagopa.swclient.mil;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import io.quarkus.logging.Log;
import it.gov.pagopa.swclient.mil.bean.Errors;

/**
 * Normalize the body of Constraint Violation Exception (BAD REQUEST) handled directly by Quarkus
 * 
 * @author Antonio Tarricone
 */
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
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
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(Throwable)
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
			.collect(Collectors.toMap(Error::getCode, Error::getDescription));

		return Response
			.status(Response.Status.BAD_REQUEST.getStatusCode())
			.entity(new Errors(errors.keySet().stream().toList(), errors.values().stream().toList()))
			.build();
	}
}

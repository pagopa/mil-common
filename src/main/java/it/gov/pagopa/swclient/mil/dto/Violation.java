/*
 * Violation.java
 *
 * 26 nov 2022
 */
package it.gov.pagopa.swclient.mil.dto;

import java.util.StringJoiner;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Violation description for BAD REQUEST response body
 * 
 * @author Antonio Tarricone
 */
public class Violation {
	/*
	 * Violation description
	 */
	@NotNull(message = "message must not be null")
	@Pattern(regexp = "^[\u0001-\uD7FF\uE000-\uFFFD\u10000-\u10FFFF]{1,256}$", message = "message must match {regexp}")
	private String message;

	/**
	 * 
	 */
	public Violation() {
	}

	/**
	 * 
	 * @param message
	 */
	public Violation(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return new StringJoiner(", ", Violation.class.getSimpleName() + "[", "]")
			.add("message='" + message + "'")
			.toString();
	}
}

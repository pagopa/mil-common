/*
 * Errors.java
 *
 * 26 nov 2022
 */
package it.gov.pagopa.swclient.mil.dto;

import java.util.List;

import io.quarkus.runtime.annotations.RegisterForReflection;

/**
 * List of violations for BAD REQUEST response body
 * 
 * @author Antonio Tarricone
 */
@RegisterForReflection
public class Errors {
	/*
	 * List of error codes
	 */
	private List<String> errors;
	
	/**
	 * 
	 */
	public Errors() {
	}

	/**
	 * @param errors
	 */
	public Errors(List<String> errors) {
		this.errors = errors;
	}

	/**
	 * @return the errors
	 */
	public List<String> getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Errors [errors=").append(errors).append("]");
		return builder.toString();
	}
}

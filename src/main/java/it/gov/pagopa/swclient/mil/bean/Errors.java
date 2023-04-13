/*
 * Errors.java
 *
 * 26 nov 2022
 */
package it.gov.pagopa.swclient.mil.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.quarkus.runtime.annotations.RegisterForReflection;

/**
 * List of violations.
 * 
 * @author Antonio Tarricone
 */
@RegisterForReflection
@JsonInclude(Include.NON_NULL)
public class Errors {
	/*
	 * List of error codes
	 */
	private List<String> errors;
	
	/*
	 * List of error descriptions.
	 */
	private List<String> descriptions;
	
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
	 * @param errors
	 * @param descriptions
	 */
	public Errors(List<String> errors, List<String> descriptions) {
		this.errors = errors;
		this.descriptions = descriptions;
	}
	
	/**
	 * @param error
	 * @param description
	 */
	public Errors(String error, String description) {
		errors = List.of(error);
		descriptions = List.of(description);
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
	
	/**
	 * @return the descriptions
	 */
	public List<String> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new StringBuilder("Errors [errors=")
			.append(errors)
			.append(", descriptions=")
			.append(descriptions)
			.append("]")
			.toString();
	}
}

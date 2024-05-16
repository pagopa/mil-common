/*
 * Errors.java
 *
 * 26 nov 2022
 */
package it.pagopa.swclient.mil.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>List of violations.</p>
 * 
 * @author Antonio Tarricone
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Accessors(chain = true)
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
	 * @param errors
	 */
	public Errors(List<String> errors) {
		this.errors = errors;
	}

	/**
	 * 
	 * @param error
	 * @param description
	 */
	public Errors(String error, String description) {
		errors = List.of(error);
		descriptions = List.of(description);
	}
}

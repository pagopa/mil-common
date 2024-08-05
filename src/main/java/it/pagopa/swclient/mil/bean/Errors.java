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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * List of errors.
 * </p>
 * 
 * @author Antonio Tarricone
 */
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
@RegisterForReflection
@JsonInclude(Include.NON_NULL)
public class Errors {
	/**
	 * <p>
	 * List of error codes.
	 * </p>
	 */
	@NonNull
	private List<String> errors; // NOSONAR

	/**
	 * <p>
	 * List of error messages.
	 * </p>
	 */
	private List<String> descriptions;

	/**
	 * <p>
	 * Constructor for a single couple error/description.
	 * </p>
	 * 
	 * @param error       Error code.
	 * @param description Error message.
	 */
	public Errors(String error, String description) {
		errors = List.of(error);
		descriptions = List.of(description);
	}
	
	/**
	 * <p>
	 * Constructor for a single error w/o description.
	 * </p>
	 * 
	 * @param error       Error code.
	 */
	public Errors(String error) {
		errors = List.of(error);
	}
}

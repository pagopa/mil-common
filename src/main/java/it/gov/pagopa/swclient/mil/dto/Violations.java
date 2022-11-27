/*
 * Violations.java
 *
 * 26 nov 2022
 */
package it.gov.pagopa.swclient.mil.dto;

import java.util.List;
import java.util.StringJoiner;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * List of violations for BAD REQUEST response body
 * 
 * @author Antonio Tarricone
 */
public class Violations {
	/*
	 * List of violations
	 */
	@NotNull(message = "violations must not be null")
	@Size(max = 32, message = "violations size must be at most {max}")
	private List<Violation> violations;

	/**
	 * 
	 */
	public Violations() {
	}

	/**
	 * 
	 * @param violations
	 */
	public Violations(@NotNull(message = "violations must not be null") @Size(max = 32, message = "violations size must be at most {max}") List<Violation> violations) {
		this.violations = violations;
	}

	/**
	 * 
	 * @return
	 */
	public List<Violation> getViolations() {
		return violations;
	}

	/**
	 * 
	 * @param violations
	 */
	public void setViolations(List<Violation> violations) {
		this.violations = violations;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return new StringJoiner(", ", Violations.class.getSimpleName() + "[", "]")
			.add("violations=" + violations)
			.toString();
	}
}

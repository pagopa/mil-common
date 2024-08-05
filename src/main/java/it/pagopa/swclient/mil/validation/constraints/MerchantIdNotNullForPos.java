/*
 * MerchantIdNotNullForPos.java
 *
 * 20 gen 2023
 */
package it.pagopa.swclient.mil.validation.constraints;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * <p>
 * If {@code Channel} equals to {@code POS}, the {@code MerchantId} must not be null.
 * </p>
 * 
 * @author Antonio Tarricone
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy = {
	MerchantIdNotNullForPosValidator.class
})
public @interface MerchantIdNotNullForPos {
	/**
	 * <p>
	 * Default key for creating error messages in case the constraint is violated.
	 * </p>
	 * 
	 * @return Default key for creating error messages in case the constraint is violated
	 */
	String message() default "";

	/**
	 * <p>
	 * Validation groups to which the constraint belongs.
	 * </p>
	 * 
	 * @return Validation groups to which the constraint belongs
	 */
	Class<?>[] groups() default {};

	/**
	 * <p>
	 * Can be used by clients of the Bean Validation API to assign custom payload objects to a
	 * constraint.
	 * </p>
	 * 
	 * @return Custom payload objects to a constraint
	 */
	Class<? extends Payload>[] payload() default {};
}
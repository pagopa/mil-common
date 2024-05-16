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
	String message() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
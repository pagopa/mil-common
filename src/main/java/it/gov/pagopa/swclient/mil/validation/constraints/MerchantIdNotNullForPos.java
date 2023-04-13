/*
 * MerchantIdNotNullForPos.java
 *
 * 20 gen 2023
 */
package it.gov.pagopa.swclient.mil.validation.constraints;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * If Channel equals to POS, the MerchantId must not be null.
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
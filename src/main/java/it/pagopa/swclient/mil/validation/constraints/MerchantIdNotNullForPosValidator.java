/*
 * MerchantIdNotNullForPosValidator.java
 *
 * 20 gen 2023
 */
package it.pagopa.swclient.mil.validation.constraints;

import it.pagopa.swclient.mil.bean.Channel;
import it.pagopa.swclient.mil.bean.CommonHeader;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * <p>
 * If {@code Channel} equals to {@code POS}, the {@code MerchantId} must not be null.
 * </p>
 * 
 * @author Antonio Tarricone
 */
public class MerchantIdNotNullForPosValidator implements ConstraintValidator<MerchantIdNotNullForPos, CommonHeader> {
	/**
	 * <p>
	 * Default constructor.
	 * </p>
	 */
	public MerchantIdNotNullForPosValidator() {
		// Default constructor.
	}

	/**
	 * <p>
	 * If {@code Channel} equals to {@code POS}, the {@code MerchantId} must not be null.
	 * </p>
	 * 
	 * @see jakarta.validation.ConstraintValidator#isValid(Object, ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(CommonHeader commonHeader, ConstraintValidatorContext context) {
		String channel = commonHeader.getChannel();
		String merchantId = commonHeader.getMerchantId();
		return !(channel != null && channel.equals(Channel.POS) && merchantId == null);
	}
}

/*
 * MerchantIdNotNullForPosValidator.java
 *
 * 20 gen 2023
 */
package it.gov.pagopa.swclient.mil.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import it.gov.pagopa.swclient.mil.bean.Channel;
import it.gov.pagopa.swclient.mil.bean.CommonHeader;

/**
 * If Channel equals to POS, the MerchantId must not be null.
 * 
 * @author Antonio Tarricone
 */
public class MerchantIdNotNullForPosValidator implements ConstraintValidator<MerchantIdNotNullForPos, CommonHeader> {
	/**
	 * @see javax.validation.ConstraintValidator#isValid(Object, ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(CommonHeader commonHeader, ConstraintValidatorContext context) {
		String channel = commonHeader.getChannel();
		String merchantId = commonHeader.getMerchantId();
		return !(channel != null && channel.equals(Channel.POS) && merchantId == null);
	}
}

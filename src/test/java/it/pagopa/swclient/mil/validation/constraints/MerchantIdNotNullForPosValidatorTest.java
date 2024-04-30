/*
 * MerchantIdNotNullForPosValidatorTest.java
 *
 * 29 apr 2024
 */
package it.pagopa.swclient.mil.validation.constraints;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import it.pagopa.swclient.mil.bean.Channel;
import it.pagopa.swclient.mil.bean.CommonHeader;

/**
 * 
 * @author antonio.tarricone
 */
@QuarkusTest
class MerchantIdNotNullForPosValidatorTest {
	/**
	 * Test method for
	 * {@link it.pagopa.swclient.mil.validation.constraints.MerchantIdNotNullForPosValidator#isValid(it.pagopa.swclient.mil.bean.CommonHeader, jakarta.validation.ConstraintValidatorContext)}.
	 */
	@Test
	void given_commonHeader_when_channelIsPosAndMerchantIdIsNotNull_then_theCommonHeaderIsValid() {
		assertTrue(new MerchantIdNotNullForPosValidator()
			.isValid(
				new CommonHeader(
					UUID.randomUUID().toString(),
					"1.0.0",
					"12345678901",
					Channel.POS,
					"abcde0123456789",
					"1234wxyz"),
				null));
	}

	/**
	 * Test method for
	 * {@link it.pagopa.swclient.mil.validation.constraints.MerchantIdNotNullForPosValidator#isValid(it.pagopa.swclient.mil.bean.CommonHeader, jakarta.validation.ConstraintValidatorContext)}.
	 */
	@Test
	void given_commonHeader_when_channelIsPosAndMerchantIdIsNull_then_theCommonHeaderIsNotValid() {
		assertFalse(new MerchantIdNotNullForPosValidator()
			.isValid(
				new CommonHeader(
					UUID.randomUUID().toString(),
					"1.0.0",
					"12345678901",
					Channel.POS,
					null,
					"1234wxyz"),
				null));
	}

	/**
	 * Test method for
	 * {@link it.pagopa.swclient.mil.validation.constraints.MerchantIdNotNullForPosValidator#isValid(it.pagopa.swclient.mil.bean.CommonHeader, jakarta.validation.ConstraintValidatorContext)}.
	 */
	@Test
	void given_commonHeader_when_channelIsNotPosAndMerchantIdIsNotNull_then_theCommonHeaderIsValid() {
		assertTrue(new MerchantIdNotNullForPosValidator()
			.isValid(
				new CommonHeader(
					UUID.randomUUID().toString(),
					"1.0.0",
					"12345678901",
					Channel.ATM,
					"abcde0123456789",
					"1234wxyz"),
				null));
	}

	/**
	 * Test method for
	 * {@link it.pagopa.swclient.mil.validation.constraints.MerchantIdNotNullForPosValidator#isValid(it.pagopa.swclient.mil.bean.CommonHeader, jakarta.validation.ConstraintValidatorContext)}.
	 */
	@Test
	void given_commonHeader_when_channelIsNotPosAndMerchantIdIsNull_then_theCommonHeaderIsValid() {
		assertTrue(new MerchantIdNotNullForPosValidator()
			.isValid(
				new CommonHeader(
					UUID.randomUUID().toString(),
					"1.0.0",
					"12345678901",
					Channel.ATM,
					null,
					"1234wxyz"),
				null));
	}

	/**
	 * Test method for
	 * {@link it.pagopa.swclient.mil.validation.constraints.MerchantIdNotNullForPosValidator#isValid(it.pagopa.swclient.mil.bean.CommonHeader, jakarta.validation.ConstraintValidatorContext)}.
	 */
	@Test
	void given_commonHeader_when_channelIsNullAndMerchantIdIsNotNull_then_theCommonHeaderIsValid() {
		assertTrue(new MerchantIdNotNullForPosValidator()
			.isValid(
				new CommonHeader(
					UUID.randomUUID().toString(),
					"1.0.0",
					"12345678901",
					null,
					"abcde0123456789",
					"1234wxyz"),
				null));
	}

	/**
	 * Test method for
	 * {@link it.pagopa.swclient.mil.validation.constraints.MerchantIdNotNullForPosValidator#isValid(it.pagopa.swclient.mil.bean.CommonHeader, jakarta.validation.ConstraintValidatorContext)}.
	 */
	@Test
	void given_commonHeader_when_channelIsNullAndMerchantIdIsNull_then_theCommonHeaderIsValid() {
		assertTrue(new MerchantIdNotNullForPosValidator()
			.isValid(
				new CommonHeader(
					UUID.randomUUID().toString(),
					"1.0.0",
					"12345678901",
					null,
					null,
					"1234wxyz"),
				null));
	}
}
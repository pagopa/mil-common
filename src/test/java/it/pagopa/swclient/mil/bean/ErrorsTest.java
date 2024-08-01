/*
 * ErrorsTest.java
 *
 * 30 apr 2024
 */
package it.pagopa.swclient.mil.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

/**
 * 
 * @author antonio.tarricone
 */
@QuarkusTest
class ErrorsTest {
	/**
	 * 
	 */
	@Test
	void given_pairCodeAndDescription_when_getLists_then_returnGivenPair() {
		List<String> codes = List.of("error_code");
		List<String> descriptions = List.of("error_description");

		Errors errors = new Errors(codes.getFirst(), descriptions.getFirst());

		assertEquals(codes, errors.getErrors());
		assertEquals(descriptions, errors.getDescriptions());
	}
}
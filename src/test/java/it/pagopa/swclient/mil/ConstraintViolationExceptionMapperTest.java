/*
 * ConstraintViolationExceptionMapperTest.java
 *
 * 29 apr 2024
 */
package it.pagopa.swclient.mil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import it.pagopa.swclient.mil.bean.Errors;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;

/**
 * 
 * @author antonio.tarricone
 */
@QuarkusTest
class ConstraintViolationExceptionMapperTest {
	/**
	 * Test method for
	 * {@link it.pagopa.swclient.mil.ConstraintViolationExceptionMapper#toResponse(jakarta.validation.ConstraintViolationException)}.
	 */
	@Test
	void given_constraintViolationExceptionWellFormed_when_mappedToResponse_then_returnResponseBodyWithVioltationsCodeAndDescription() {
		Set<MyConstraintViolation> constraintViolations = Stream.of(
			new MyConstraintViolation(ErrorCode.REQUEST_ID_MUST_NOT_BE_NULL_MSG),
			new MyConstraintViolation(ErrorCode.VERSION_MUST_MATCH_REGEXP_MSG))
			.collect(Collectors.toSet());
		ConstraintViolationException exc = new ConstraintViolationException(constraintViolations);

		Response response = new ConstraintViolationExceptionMapper().toResponse(exc);

		Object entity = response.getEntity();
		assertEquals(Errors.class, entity.getClass());

		Errors errors = (Errors) entity;
		assertThat(errors.getErrors()).containsExactlyInAnyOrderElementsOf(List.of(ErrorCode.REQUEST_ID_MUST_NOT_BE_NULL, ErrorCode.VERSION_MUST_MATCH_REGEXP));
		assertThat(errors.getDescriptions()).containsExactlyInAnyOrderElementsOf(List.of(ErrorCode.REQUEST_ID_MUST_NOT_BE_NULL_MSG, ErrorCode.VERSION_MUST_MATCH_REGEXP_MSG));
	}

	/**
	 * Test method for
	 * {@link it.pagopa.swclient.mil.ConstraintViolationExceptionMapper#toResponse(jakarta.validation.ConstraintViolationException)}.
	 */
	@Test
	void given_constraintViolationExceptionWithoutErrorCode_when_mappedToResponse_then_returnResponseBodyWithVioltationsDescription() {
		Set<MyConstraintViolation> constraintViolations = Stream.of(
			new MyConstraintViolation(ErrorCode.REQUEST_ID_MUST_NOT_BE_NULL_MSG),
			new MyConstraintViolation(ErrorCode.VERSION_MUST_MATCH_REGEXP_DESCR))
			.collect(Collectors.toSet());
		ConstraintViolationException exc = new ConstraintViolationException(constraintViolations);

		Response response = new ConstraintViolationExceptionMapper().toResponse(exc);

		Object entity = response.getEntity();
		assertEquals(Errors.class, entity.getClass());

		Errors errors = (Errors) entity;
		assertThat(errors.getErrors()).containsExactlyInAnyOrderElementsOf(List.of(ErrorCode.REQUEST_ID_MUST_NOT_BE_NULL, ""));
		assertThat(errors.getDescriptions()).containsExactlyInAnyOrderElementsOf(List.of(ErrorCode.REQUEST_ID_MUST_NOT_BE_NULL_MSG, ErrorCode.VERSION_MUST_MATCH_REGEXP_DESCR));
	}
}
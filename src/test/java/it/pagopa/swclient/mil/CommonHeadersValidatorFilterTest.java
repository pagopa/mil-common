/*
 * CommonHeadersValidatorFilterTest.java
 *
 * 29 apr 2024
 */
package it.pagopa.swclient.mil;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import it.pagopa.swclient.mil.bean.HeaderParamName;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.container.ContainerRequestContext;

/**
 * 
 * @author Antonio Tarricone
 */
@QuarkusTest
class CommonHeadersValidatorFilterTest {
	@Test
	void given_request_when_requestIdAndVersionAreOk_then_noExcpetionMustBeThrown() {
		ContainerRequestContext context = mock(ContainerRequestContext.class);
		when(context.getHeaderString(HeaderParamName.REQUEST_ID)).thenReturn(UUID.randomUUID().toString());
		when(context.getHeaderString(HeaderParamName.VERSION)).thenReturn("1.0");

		assertDoesNotThrow(() -> new CommonHeadersValidatorFilter().filter(context));
	}

	@Test
	void given_request_when_requestIdAndVersionAreNotSet_then_noExcpetionMustBeThrown() {
		ContainerRequestContext context = mock(ContainerRequestContext.class);

		assertDoesNotThrow(() -> new CommonHeadersValidatorFilter().filter(context));
	}

	@Test
	void given_request_when_requestIdIsInvalidAndVersionIsValid_then_excpetionMustBeThrown() {
		ContainerRequestContext context = mock(ContainerRequestContext.class);
		when(context.getHeaderString(HeaderParamName.REQUEST_ID)).thenReturn("");
		when(context.getHeaderString(HeaderParamName.VERSION)).thenReturn("1.0");

		CommonHeadersValidatorFilter filter = new CommonHeadersValidatorFilter();
		assertThrows(BadRequestException.class, () -> filter.filter(context));
	}

	@Test
	void given_request_when_requestIdIsInvalidAndVersionIsNotSet_then_excpetionMustBeThrown() {
		ContainerRequestContext context = mock(ContainerRequestContext.class);
		when(context.getHeaderString(HeaderParamName.REQUEST_ID)).thenReturn("");

		CommonHeadersValidatorFilter filter = new CommonHeadersValidatorFilter();
		assertThrows(BadRequestException.class, () -> filter.filter(context));
	}

	@Test
	void given_request_when_requestIdIsValidAndVersionIsInvalid_then_excpetionMustBeThrown() {
		ContainerRequestContext context = mock(ContainerRequestContext.class);
		when(context.getHeaderString(HeaderParamName.REQUEST_ID)).thenReturn(UUID.randomUUID().toString());
		when(context.getHeaderString(HeaderParamName.VERSION)).thenReturn(new String(new byte[] {
			0
		}));

		CommonHeadersValidatorFilter filter = new CommonHeadersValidatorFilter();
		assertThrows(BadRequestException.class, () -> filter.filter(context));
	}

	@Test
	void given_request_when_requestIdIsNotSetAndVersionIsInvalid_then_excpetionMustBeThrown() {
		ContainerRequestContext context = mock(ContainerRequestContext.class);
		when(context.getHeaderString(HeaderParamName.VERSION)).thenReturn(new String(new byte[] {
			0
		}));

		CommonHeadersValidatorFilter filter = new CommonHeadersValidatorFilter();
		assertThrows(BadRequestException.class, () -> filter.filter(context));
	}
}

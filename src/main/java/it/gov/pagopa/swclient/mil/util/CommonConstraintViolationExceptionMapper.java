package it.gov.pagopa.swclient.mil.util;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import io.quarkus.logging.Log;
import it.gov.pagopa.swclient.mil.dto.Violation;
import it.gov.pagopa.swclient.mil.dto.Violations;

@Provider
public class CommonConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
	public Response toResponse(ConstraintViolationException e) {
		List<Violation> violationList = e.getConstraintViolations().stream()
			.map(c -> new Violation(c.getMessage()))
			.toList();

		Violations violations = new Violations(violationList);

		Log.errorf("[%s] Constraint violation: %s", Error.CONTRAINT_VIOLATION, violations);

		return Response
			.status(Response.Status.BAD_REQUEST.getStatusCode(), Error.CONTRAINT_VIOLATION)
			.entity(violations)
			.build();
	}
}

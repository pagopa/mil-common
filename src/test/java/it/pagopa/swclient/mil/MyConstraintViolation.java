/*
 * MyConstraintViolation.java
 *
 * 30 apr 2024
 */
package it.pagopa.swclient.mil;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.metadata.ConstraintDescriptor;

/**
 * 
 * @author antonio.tarricone
 */
public class MyConstraintViolation implements ConstraintViolation<Object> {
	private String message;

	public MyConstraintViolation(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String getMessageTemplate() {
		return null;
	}

	@Override
	public Object getRootBean() {
		return null;
	}

	@Override
	public Class<Object> getRootBeanClass() {
		return null;
	}

	@Override
	public Object getLeafBean() {
		return null;
	}

	@Override
	public Object[] getExecutableParameters() {
		return null;
	}

	@Override
	public Object getExecutableReturnValue() {
		return null;
	}

	@Override
	public Path getPropertyPath() {
		return null;
	}

	@Override
	public Object getInvalidValue() {
		return null;
	}

	@Override
	public ConstraintDescriptor<?> getConstraintDescriptor() {
		return null;
	}

	@Override
	public <U> U unwrap(Class<U> type) {
		return null;
	}
}

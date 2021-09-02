package com.vti.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidationUtils {
	public static <T> boolean validate(T dto) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		Set<ConstraintViolation<T>> constraintViolations = validator.validate(dto);

		if (null == constraintViolations || constraintViolations.size() == 0) {
			return true;
		}

		for (ConstraintViolation<T> violation : constraintViolations) {
			System.out.println(violation.getMessage());
		}

		return false;
	}
}

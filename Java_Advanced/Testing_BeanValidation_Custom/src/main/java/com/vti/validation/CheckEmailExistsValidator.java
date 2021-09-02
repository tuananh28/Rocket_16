package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mysql.cj.util.StringUtils;
import com.vti.repository.AccountRepository;

public class CheckEmailExistsValidator implements ConstraintValidator<CheckEmailNotExists, String> {
	private AccountRepository accRepository;

	@Override
	public void initialize(CheckEmailNotExists constraintAnnotation) {
		accRepository = new AccountRepository();
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (StringUtils.isNullOrEmpty(email)) {
			return false;
		}
		Boolean flag = accRepository.isAccountExistsByEmail(email);
		return !flag;
	}

}


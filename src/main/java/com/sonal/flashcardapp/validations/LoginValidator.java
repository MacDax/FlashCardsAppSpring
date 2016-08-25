package com.sonal.flashcardapp.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> targetClass) {
			return String.class.equals(targetClass);
	}

	@Override
	public void validate(Object loginObj, Errors errors) {
		String tstEmail = (String) loginObj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");
		
	}

}

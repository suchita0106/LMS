package com.librarymanagement.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.librarymanagement.pojo.UserAccount;
import org.springframework.stereotype.Component;

@Component
public class UserAccValidator implements Validator {
	
	 public boolean supports(Class<?> type) {
	        return (UserAccount.class.equals(type));
	    }

	    @Override
	    public void validate(Object o, Errors errors) {
	    	UserAccount useracc = (UserAccount) o;

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.empty", "Username cannot be empty");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password cannot be empty");
	        
	        if (!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", useracc.getUsername())) {
	            errors.rejectValue("username", "error.invalid.username", "Username should be in email format");
	        }

	        if (!Pattern.matches("^[a-zA-Z0-9]*$", useracc.getPassword())) {
	            errors.rejectValue("password", "error.invalid.password", "Password should contain only alphanumeric characters");
	        }

	        
	    }

}

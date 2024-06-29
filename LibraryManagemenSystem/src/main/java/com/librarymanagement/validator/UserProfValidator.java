package com.librarymanagement.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.librarymanagement.pojo.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class UserProfValidator implements Validator {
    public boolean supports(Class<?> type) {
        return (UserProfile.class.equals(type));
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserProfile userprof = (UserProfile) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fname", "fname.empty", "First name cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lname", "lname.empty", "Last name cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobno", "mobno.empty", "Mobile number cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "address.empty", "Address cannot be empty");

        if (!Pattern.matches("^[a-zA-Z]*$", userprof.getFname())) {
            errors.rejectValue("fname", "error.invalid.fname", "First name should contain only alphabets");
        }

        if (!Pattern.matches("^[a-zA-Z]*$", userprof.getLname())) {
            errors.rejectValue("lname", "error.invalid.lname", "Last name should contain only alphabets");
        }
        
        if (!Pattern.matches("^-?[1-9]\\d*(\\.\\d+)?$", userprof.getMobno())) {
            errors.rejectValue("mobno", "error.invalid.mobno", "Mobile number is required");
        }

        if (!Pattern.matches("^[a-zA-Z0-9 ,]*$", userprof.getAddress())) {
            errors.rejectValue("address", "error.invalid.address", "Address should contain only alphanumeric characters, spaces, and commas");
        }
    }
}

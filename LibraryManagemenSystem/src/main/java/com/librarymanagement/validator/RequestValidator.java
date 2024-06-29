package com.librarymanagement.validator;

import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.librarymanagement.pojo.Request;
import org.springframework.stereotype.Component;

@Component
public class RequestValidator implements Validator {
    public boolean supports(Class<?> type) {
        return (Request.class.equals(type));
    }

    @Override
    public void validate(Object o, Errors errors) {
        Request request = (Request) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookName", "bookName.empty", "Book name cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty", "User name (username) cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adminusername", "adminusername.empty", "Admin username cannot be empty");

        if (request.getBookID() == null) {
            errors.rejectValue("bookID", "bookID.null", "Book ID cannot be null");
        }

        if (request.getUserId() == null) {
            errors.rejectValue("userId", "userId.null", "User ID cannot be null");
        }

        if (request.getIssueDate() == null) {
            errors.rejectValue("IssueDate", "issueDate.null", "Issue date cannot be null");
        }

        if (request.getReturnDate() == null) {
            errors.rejectValue("ReturnDate", "returnDate.null", "Return date cannot be null");
        }

   
        if (request.getIssueDate() != null && request.getReturnDate() != null) {
            if (request.getIssueDate().after(request.getReturnDate())) {
                errors.rejectValue("IssueDate", "date.invalid", "Issue date cannot be after return date");
            }
        }
    }
}

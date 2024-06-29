package com.librarymanagement.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.librarymanagement.pojo.Book;

@Component
public class BookValidator implements Validator {
    public boolean supports(Class<?> type) {
        return (Book.class.equals(type));
    }

    @Override
    public void validate(Object o, Errors errors) {
        Book book = (Book) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.empty", "Title cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "author.empty", "Author cannot be empty");

        if (book.getQuantity() == null) {
            errors.rejectValue("quantity", "quantity.null", "Quantity cannot be null");
        } else if (book.getQuantity() < 0) {
            errors.rejectValue("quantity", "quantity.invalid", "Quantity must be a positive number");
        }
    }
}

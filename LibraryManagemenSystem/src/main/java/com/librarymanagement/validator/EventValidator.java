package com.librarymanagement.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.librarymanagement.pojo.Event;
import org.springframework.stereotype.Component;

@Component
public class EventValidator implements Validator {
    public boolean supports(Class<?> type) {
        return (Event.class.equals(type));
    }

    @Override
    public void validate(Object o, Errors errors) {
        Event event = (Event) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventName", "eventName.empty", "Event name cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "location.empty", "Event location cannot be empty");

        if (event.getStartTime() == null) {
            errors.rejectValue("startTime", "startTime.null", "Start time cannot be null");
        }

        if (event.getEndTime() == null) {
            errors.rejectValue("endTime", "endTime.null", "End time cannot be null");
        }

        if (event.getCapacity() <= 0) {
            errors.rejectValue("capacity", "capacity.invalid", "Capacity must be a positive number");
        }

        if (event.getStartTime() != null && event.getEndTime() != null) {
            if (event.getStartTime().after(event.getEndTime())) {
                errors.rejectValue("startTime", "time.invalid", "Start time cannot be after end time");
            }
        }
    }
}

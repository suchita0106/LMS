package com.librarymanagement.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.librarymanagement.pojo.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomValidator implements Validator {
    public boolean supports(Class<?> type) {
        return (Room.class.equals(type));
    }

    @Override
    public void validate(Object o, Errors errors) {
    	Room room = (Room) o;
    	
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roomName", "roomName.empty", "Room name cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startTime", "startTime.empty", "Start time cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endTime", "endTime.empty", "End time cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status", "status.empty", "Room status cannot be empty");
        
        if (room.getCapacity() <= 0) {
            errors.rejectValue("capacity", "capacity.positive", "Capacity must be greater than zero");
        }

        if (room.getStartTime() != null && room.getEndTime() != null) {
            if (room.getStartTime().after(room.getEndTime())) {
                errors.rejectValue("startTime", "startTime.beforeEndTime", "Start time must be before end time");
            }
        }
    }
}

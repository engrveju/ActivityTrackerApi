package com.dev.activitytracker.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long userId){
        super("The user with the id "+userId+" does not exist in our database");
    }
}

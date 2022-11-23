package com.dev.activitytracker.exceptions;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(Long userId){
        super("There is no such task for the user with the Id: "+ userId+" in our database");
    }
}

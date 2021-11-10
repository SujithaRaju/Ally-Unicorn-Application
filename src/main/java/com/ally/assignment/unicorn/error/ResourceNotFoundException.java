package com.ally.assignment.unicorn.error;


public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Long unicornId)
    {
        super("Unicorn Resource Not Found : " +unicornId);
    }

}

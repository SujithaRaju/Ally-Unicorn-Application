package com.ally.assignment.unicorn.error;

public class ResourceAlreadyExists extends RuntimeException{

    private static final long serialVersionUID = 1L;


    public ResourceAlreadyExists(Long unicornId)
    {
        super("This Unicorn ID is Already Exist : " +unicornId);
    }
}

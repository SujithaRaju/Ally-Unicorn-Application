package com.ally.assignment.unicorn.error;

public class CustomExceptions extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CustomExceptions(String message)
    {
        super("Resource is already Empty : " +message);
    }
}

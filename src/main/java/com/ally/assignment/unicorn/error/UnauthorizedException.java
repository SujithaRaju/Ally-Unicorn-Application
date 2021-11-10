package com.ally.assignment.unicorn.error;

public class UnauthorizedException extends RuntimeException{

   private static final long serialVersionUID = 1L;

    public UnauthorizedException(String message)
    {
        super("You are Not authorized to access this resource: "+message);
    }
}

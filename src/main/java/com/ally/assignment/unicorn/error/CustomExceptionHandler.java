package com.ally.assignment.unicorn.error;

import com.ally.assignment.unicorn.utils.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler

    {

        @ExceptionHandler(ResourceNotFoundException.class)
        public final ResponseEntity<ExceptionResponse> unicornResourceNotFoundException(ResourceNotFoundException resourceNotFoundException)
        {
            ExceptionResponse response= new ExceptionResponse();
            response.setMessage("NOT_FOUND");
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setTimestamp(LocalDateTime.now());
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

        }

        @ExceptionHandler(ResourceAlreadyExists.class)
        public ResponseEntity<ExceptionResponse> unicornResourceAlreadyExists(ResourceAlreadyExists resourceAlreadyExists)
        {
            ExceptionResponse response=new ExceptionResponse();
            response.setMessage("CONFLICT");
            response.setStatus(HttpStatus.CONFLICT.value());
            response.setTimestamp(LocalDateTime.now());
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

        @ExceptionHandler(CustomExceptions.class)
        public ResponseEntity<ExceptionResponse> customException(CustomExceptions customExceptions)
        {
            ExceptionResponse response=new ExceptionResponse();
            response.setMessage("BAD_REQUEST");
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setTimestamp(LocalDateTime.now());

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(UnauthorizedException.class)
        public ResponseEntity<ExceptionResponse> unauthorizedException(UnauthorizedException ex) {
            ExceptionResponse response=new ExceptionResponse();
            response.setMessage("UNAUTHORIZED");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setTimestamp(LocalDateTime.now());

            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }


    }


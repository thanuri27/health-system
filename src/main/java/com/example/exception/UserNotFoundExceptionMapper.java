/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// This is a standard Java package declaration
package com.example.exception;

/**
 *
 * @author Hamed
 */

// Import statements for required classes
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// Annotation to register this class as a provider for exception mapping
@Provider

// This class implements the ExceptionMapper interface for handling UserNotFoundException
public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException> {

    // Create a logger instance for this class
    private static final Logger LOGGER = LoggerFactory.getLogger(UserNotFoundExceptionMapper.class);

    // Implement the toResponse method from the ExceptionMapper interface
    @Override
    public Response toResponse(UserNotFoundException exception) {
        // Log the exception message and stack trace with an error level
        LOGGER.error("UserNotFoundException caught: {}", exception.getMessage(), exception);

        // Create and return a Response object with a NOT_FOUND status, the exception message as the entity, and plain text media type
        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}
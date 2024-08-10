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

// This class extends the RuntimeException class and represents an exception that is thrown when a user is not found
public class UserNotFoundException extends RuntimeException {

    // Constructor that takes a message as a parameter
    public UserNotFoundException(String message) {
        // Call the constructor of the superclass (RuntimeException) and pass the message to it
        super(message);
    }
}
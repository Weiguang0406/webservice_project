package com.example.restservice.Exception;

import org.springframework.http.HttpStatus;

public class StudentNotFoundException extends RuntimeException
{
    // parameterized constructor that accepts only detail message

    public StudentNotFoundException (String message, HttpStatus notFound)
    {
        // calling parent Exception class constructor
        super(message);
    }
}

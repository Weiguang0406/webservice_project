package com.example.restservice.Exception;

public class StudentNumExistException extends RuntimeException
{
    // parameterized constructor that accepts only detail message

    public StudentNumExistException(String message)
    {
        // calling parent Exception class constructor
        super(message);
    }
}

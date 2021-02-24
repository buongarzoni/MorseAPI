package com.translator.morseapi.exceptions;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String exception){
        super(exception);
    }
}

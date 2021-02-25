package com.translator.morseapi.exceptions;

public class InvalidCharacterException extends RuntimeException{
    public InvalidCharacterException(String exception){
        super(exception);
    }
}

package com.translator.morseapi.exceptions;

public class ErrorInJSONFileException extends RuntimeException{
    public ErrorInJSONFileException(String exception){
        super(exception);
    }
}

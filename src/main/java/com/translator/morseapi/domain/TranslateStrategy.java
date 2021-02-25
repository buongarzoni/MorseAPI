package com.translator.morseapi.domain;

import com.translator.morseapi.exceptions.InvalidInputException;

import java.util.HashMap;
import java.util.List;

public abstract class TranslateStrategy {

    protected String message;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public abstract String translate();

    protected String translate(List<String> originalMessage, HashMap<String, String> dictionary, String separator){

        StringBuilder translatedMessage = new StringBuilder();

        originalMessage.forEach(string -> {
            if(dictionary.containsKey(string)){
                translatedMessage.append(dictionary.get(string));
                translatedMessage.append(separator);
            }else{
                throw new InvalidInputException("No se reconoce el caracter ["+string+"]");
            }
        });

        return translatedMessage.toString().trim();
    }
}

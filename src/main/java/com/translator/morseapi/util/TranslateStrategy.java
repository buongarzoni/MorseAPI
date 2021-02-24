package com.translator.morseapi.util;

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
        for (String string : originalMessage) {
            if(dictionary.containsKey(string)){
                translatedMessage.append(dictionary.get(string));
                translatedMessage.append(separator);
            }else{
                throw new RuntimeException("No se reconoce el caracter ["+string+"]");
            }
        }
        return translatedMessage.toString();
    }
}

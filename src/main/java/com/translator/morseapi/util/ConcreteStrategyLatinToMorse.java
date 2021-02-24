package com.translator.morseapi.util;

import com.translator.morseapi.exceptions.InvalidInputException;
import com.translator.morseapi.model.Alphabets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConcreteStrategyLatinToMorse extends TranslateStrategy{

    public ConcreteStrategyLatinToMorse(String message){
        this.message = message;
    }

    public String translate(){
        return translate2Morse();
    }

    private String translate2Morse(){
        message = message.toUpperCase();

        if(isLatin()){
            List<String> messageInLatin = new ArrayList<>(Arrays.asList(message.split("")));
            Collections.replaceAll(messageInLatin,""," ");

            return translate(messageInLatin, Alphabets.LATIN_TO_MORSE," ");
        }else{
            throw new InvalidInputException("Algún caracter es inválido");
        }
    }

    private boolean isLatin(){
        return message.matches("^[A-Z0-9. ]+$");
    }

}

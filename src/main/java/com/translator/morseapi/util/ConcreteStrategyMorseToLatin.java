package com.translator.morseapi.util;

import com.translator.morseapi.exceptions.InvalidInputException;
import com.translator.morseapi.model.Alphabets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConcreteStrategyMorseToLatin extends TranslateStrategy{

    public ConcreteStrategyMorseToLatin(String message){
        this.message = message;
    }

    public String translate(){
        return translate2Human();
    }

    private String translate2Human(){
        if(isMorse()){
            List<String> messageInMorse = new ArrayList<>(Arrays.asList(message.split(" ")));
            Collections.replaceAll(messageInMorse,""," ");

            return translate(messageInMorse, Alphabets.MORSE_TO_LATIN,"");
        }else{
            throw new InvalidInputException("El código no es morse");
        }
    }

    private boolean isMorse(){
        return message.matches("^[.\\- ]+$");
    }
}

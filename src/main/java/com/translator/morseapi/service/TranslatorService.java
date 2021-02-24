package com.translator.morseapi.service;

import com.translator.morseapi.model.MorseCode;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TranslatorService {

    public String translate2Human(String message){
        if(!isMorse(message)){
            throw new RuntimeException("No es morse");
        }
        List<String> messageInMorse = new ArrayList<>(Arrays.asList(message.split(" ")));
        Collections.replaceAll(messageInMorse,""," ");

        return translate(messageInMorse,MorseCode.TRANSLATION_TABLE_TO_HUMAN,"");
    }

    private boolean isMorse(String message){
        return message.matches("^[.\\- ]+$");
    }

    public String translate2Morse(String message){
        message = message.toUpperCase();
        List<String> messageInHuman = new ArrayList<>(Arrays.asList(message.split("")));
        Collections.replaceAll(messageInHuman,""," ");

        return translate(messageInHuman,MorseCode.TRANSLATION_TABLE_TO_MORSE," ");
    }

    private String translate(List<String> originalMessage, HashMap<String, String> dictionary, String separator){

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

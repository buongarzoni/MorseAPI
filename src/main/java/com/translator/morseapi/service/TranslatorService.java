package com.translator.morseapi.service;

import com.translator.morseapi.exceptions.InvalidInputException;
import com.translator.morseapi.model.Alphabets;
import com.translator.morseapi.util.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TranslatorService {

    Context context = new Context();

    public String translate2Morse(String message){
        if(isLatin(message)){
            context.setTranslateStrategy(new ConcreteStrategyLatinToMorse(message));
        }else{
            throw new InvalidInputException("Algún caracter es inválido");
        }
        return context.executeTranslation();
    }

    public String translate2Human(String message){
        if(isMorse(message)){
            context.setTranslateStrategy(new ConcreteStrategyMorseToLatin(message));
        }else{
            throw new InvalidInputException("El código no es morse");
        }
        return context.executeTranslation();
    }


    private boolean isBinary(String message){
        return message.matches("^[0-1]+$");
    }

    private boolean isMorse(String message){
        return message.matches("^[.\\- ]+$");
    }

    private boolean isLatin(String message){
        return message.matches("^[A-Za-z0-9. ]+$");
    }

}

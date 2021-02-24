package com.translator.morseapi.service;

import com.translator.morseapi.model.Alphabets;
import com.translator.morseapi.util.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TranslatorService {

    Context context = new Context();

    public String translate(String message){
        if(isBinary(message)){
            context.setTranslateStrategy(new ConcreteStrategyPulsesToMorse(message));
        }else if(isMorse(message)){
            context.setTranslateStrategy(new ConcreteStrategyMorseToLatin(message));
        }else if(isLatin(message)){
            context.setTranslateStrategy(new ConcreteStrategyLatinToMorse(message));
        }else{
            throw new RuntimeException("No se reconoce el lenguaje");
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

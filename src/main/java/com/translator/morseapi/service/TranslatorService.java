package com.translator.morseapi.service;

import com.translator.morseapi.exceptions.InvalidInputException;
import com.translator.morseapi.model.Alphabets;
import com.translator.morseapi.model.ParseJSONFromFile;
import com.translator.morseapi.util.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TranslatorService {

    Context context = new Context();

    public String translate2Morse(String message){
        context.setTranslateStrategy(new ConcreteStrategyLatinToMorse(message));
        return context.executeTranslation();
    }

    public String translate2Human(String message){
        context.setTranslateStrategy(new ConcreteStrategyMorseToLatin(message));
        return context.executeTranslation();
    }

    public String pulseToMorse(String message){
        context.setTranslateStrategy(new ConcreteStrategyPulsesToMorse(message));
        return context.executeTranslation();
    }







}

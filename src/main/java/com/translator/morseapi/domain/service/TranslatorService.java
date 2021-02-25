package com.translator.morseapi.domain.service;

import com.translator.morseapi.domain.ConcreteStrategyLatinToMorse;
import com.translator.morseapi.domain.ConcreteStrategyMorseToLatin;
import com.translator.morseapi.domain.ConcreteStrategyPulsesToMorse;
import com.translator.morseapi.domain.Context;
import org.springframework.stereotype.Service;

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

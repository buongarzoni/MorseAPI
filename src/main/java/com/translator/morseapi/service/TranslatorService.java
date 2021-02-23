package com.translator.morseapi.service;

import com.translator.morseapi.model.Message;
import org.springframework.stereotype.Service;

@Service
public class TranslatorService {

    public Message postMorseToHumanService(Message message){
        return message;
    }
}

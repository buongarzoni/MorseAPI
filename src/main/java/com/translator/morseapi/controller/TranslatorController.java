package com.translator.morseapi.controller;

import com.translator.morseapi.model.Message;
import com.translator.morseapi.service.TranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslatorController {
    @Autowired
    TranslatorService translatorService;
    @PostMapping("/MorseToHuman")
    public Message postMorseToHuman(@RequestBody Message message) {

        return translatorService.postMorseToHumanService(message);
    }

    @PostMapping("/HumanToMorse")
    public String postHumanToMorse() {
        return "Greetings from Spring Boot!";
    }
}

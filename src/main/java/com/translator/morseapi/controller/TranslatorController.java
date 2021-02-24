package com.translator.morseapi.controller;

import com.translator.morseapi.model.Message;
import com.translator.morseapi.service.TranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TranslatorController {
    @Autowired
    private TranslatorService translatorService;
    @PostMapping("/MorseToHuman")
    public ResponseEntity<?> postMorseToHuman(@RequestBody Message message) {
        HashMap<String, String> response = new HashMap<>();
        response.put("code", HttpStatus.OK.toString());
        response.put("response", translatorService.translate2Human(message.getText()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/HumanToMorse")
    public ResponseEntity<?> postHumanToMorse(@RequestBody Message message) {
        HashMap<String, String> response = new HashMap<>();
        response.put("code", HttpStatus.OK.toString());
        response.put("response", translatorService.translate2Morse(message.getText()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<?> handleInvalidDNAException(Exception e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("code", HttpStatus.BAD_REQUEST.toString());
        response.put("response", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

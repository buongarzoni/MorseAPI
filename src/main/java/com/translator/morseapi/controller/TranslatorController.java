package com.translator.morseapi.controller;

import com.translator.morseapi.model.Message;
import com.translator.morseapi.service.TranslatorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Api(tags = {"Translator"})
@RestController
public class TranslatorController {
    @Autowired
    private TranslatorService translatorService;
    @PostMapping("/2Morse")
    public ResponseEntity<?> postHumanToMorse(@RequestBody Message message) {
        HashMap<String, String> response = new HashMap<>();
        response.put("code", Integer.toString(HttpStatus.OK.value()));
        response.put("response", translatorService.translate2Morse(message.getText()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/2Human")
    public ResponseEntity<?> postMorseToHuman(@RequestBody Message message) {
        HashMap<String, String> response = new HashMap<>();
        response.put("code", Integer.toString(HttpStatus.OK.value()));
        response.put("response", translatorService.translate2Human(message.getText()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<?> handleException(Exception e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("code", HttpStatus.BAD_REQUEST.toString());
        response.put("response", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

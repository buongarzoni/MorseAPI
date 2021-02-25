package com.translator.morseapi.controller;

import com.translator.morseapi.domain.model.Message;
import com.translator.morseapi.domain.service.TranslatorService;
import com.translator.morseapi.exceptions.ErrorInJSONFileException;
import com.translator.morseapi.exceptions.InvalidCharacterException;
import com.translator.morseapi.exceptions.InvalidInputException;
import io.swagger.annotations.Api;
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

    @ExceptionHandler({ ErrorInJSONFileException.class })
    public ResponseEntity<?> handleException(ErrorInJSONFileException e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("code", HttpStatus.INTERNAL_SERVER_ERROR.toString());
        response.put("response", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ InvalidCharacterException.class , InvalidInputException.class})
    public ResponseEntity<?> handleException(RuntimeException e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("code", HttpStatus.BAD_REQUEST.toString());
        response.put("response", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}

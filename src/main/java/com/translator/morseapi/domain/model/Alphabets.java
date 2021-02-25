package com.translator.morseapi.domain.model;

import com.translator.morseapi.exceptions.ErrorInJSONFileException;
import com.translator.morseapi.util.ParseJSONFromFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.HashMap;

public class Alphabets {

    public static final HashMap<String, String> LATIN_TO_MORSE;
    public static final HashMap<String, String> MORSE_TO_LATIN;

    static {
        try {
            LATIN_TO_MORSE = ParseJSONFromFile.jsonFileToHashMap(ResourceUtils.getFile("classpath:alphabets/LatinToMorse.json").toPath().toString());
        } catch (Exception e) {
            throw new ErrorInJSONFileException(e.toString());
        }
    }

    static {
        try {
            MORSE_TO_LATIN = ParseJSONFromFile.jsonFileToHashMap(ResourceUtils.getFile("classpath:alphabets/MorseToLatin.json").toPath().toString());
        } catch (Exception e) {
            throw new ErrorInJSONFileException(e.toString());
        }
    }
}

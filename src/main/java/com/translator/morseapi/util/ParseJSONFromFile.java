package com.translator.morseapi.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.translator.morseapi.exceptions.ErrorInJSONFileException;

import java.nio.file.Paths;
import java.util.HashMap;

public class ParseJSONFromFile {

    public static HashMap<String, String> jsonFileToHashMap(String path){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(Paths.get(path).toFile(), HashMap.class);
        } catch (Exception ex) {
            throw new ErrorInJSONFileException("Error interno");
        }
    }
}

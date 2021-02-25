package com.translator.morseapi.domain.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.translator.morseapi.util.ParseJSONFromFile;

import java.util.HashMap;

public class Alphabets {

    public static final HashMap<String, String> LATIN_TO_MORSE = ParseJSONFromFile.jsonFileToHashMap("src\\main\\resources\\alphabets\\LatinToMorse.json");

    public static final HashMap<String, String> MORSE_TO_LATIN = ParseJSONFromFile.jsonFileToHashMap("src\\main\\resources\\alphabets\\MorseToLatin.json");
}

package com.translator.morseapi.domain;

import com.translator.morseapi.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConcreteStrategyPulsesToMorse extends TranslateStrategy{
    private int averageZero=0;
    private int averageOne=0;

    public ConcreteStrategyPulsesToMorse(String message){
        this.message = message;
    }

    public String translate(){
        return decodeBits2Morse();
    }

    private String decodeBits2Morse(){
        if(isBinary()){
            setAverageValues();
            return decode();
        }else{
            throw new InvalidInputException("El código no es binario");
        }
    }

    private void setAverageValues(){
        List<String> zeroList = new ArrayList<>(
                Arrays.asList(
                        message.replaceAll("(1+)", " ").trim().split(" ")
                )
        );

        List<String> oneList = new ArrayList<>(
                Arrays.asList(
                        message.replaceAll("(0+)", " ").trim().split(" ")
                )
        );

        zeroList.remove(0);
        zeroList.remove(zeroList.size()-1);

        averageZero=(Collections.max(zeroList).length()+Collections.min(zeroList).length())/2;
        averageOne=(Collections.max(oneList).length()+Collections.min(oneList).length())/2;
    }

    private String decode(){

        List<String> binarySplitedMessage = new ArrayList<>();
        Matcher m = Pattern.compile("(0+|1+)").matcher(message);

        while(m.find()) {
            binarySplitedMessage.add(m.group(1));
        }
        binarySplitedMessage.remove(0);
        binarySplitedMessage.remove(binarySplitedMessage.size()-1);

        StringBuilder messageInMorse = new StringBuilder();
        StringBuilder symbol = new StringBuilder();
        for (String element :binarySplitedMessage) {
            if(element.matches("^[0]+$")){
                if(element.length()>= averageZero){
                    messageInMorse.append(symbol.toString());
                    symbol.delete(0, symbol.length());
                    messageInMorse.append(" ");
                }
            }else{
                if(element.length()>= averageOne){
                    symbol.append("-");
                }else{
                    symbol.append(".");
                }
            }
        }
        messageInMorse.append(symbol.toString());
        return messageInMorse.toString();
    }

    private boolean isBinary(){
        return message.matches("^[0-1]+$");
    }
}

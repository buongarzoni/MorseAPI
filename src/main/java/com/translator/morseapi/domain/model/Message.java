package com.translator.morseapi.domain.model;


import io.swagger.annotations.ApiModelProperty;

public class Message {

    @ApiModelProperty(dataType = "String",example = "Hola MeLi",required = true)
    private String text;

    public Message() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

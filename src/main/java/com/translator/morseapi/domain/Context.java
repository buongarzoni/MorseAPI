package com.translator.morseapi.domain;

public class Context {
    private TranslateStrategy translateStrategy;

    public void setTranslateStrategy(TranslateStrategy translateStrategy) {
        this.translateStrategy = translateStrategy;
    }

    public String executeTranslation(){
        return translateStrategy.translate();
    }

}

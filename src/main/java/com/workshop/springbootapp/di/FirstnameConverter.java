package com.workshop.springbootapp.di;

import org.springframework.stereotype.Component;

@Component
public class FirstnameConverter {

    private StringProcessor stringProcessor;

    public FirstnameConverter(StringProcessor stringProcessor) {
        this.stringProcessor = stringProcessor;
    }

    public String convert(String string) {
        return stringProcessor.process(string);
    }
}

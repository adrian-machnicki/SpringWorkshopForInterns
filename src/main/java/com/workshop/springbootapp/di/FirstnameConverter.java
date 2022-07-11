package com.workshop.springbootapp.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FirstnameConverter {

    private final StringProcessor stringProcessor;

    public FirstnameConverter(@Qualifier("defaultStringProcessor") StringProcessor stringProcessor) {
        this.stringProcessor = stringProcessor;
    }

    public String convert(String string) {
        return stringProcessor.process(string);
    }
}

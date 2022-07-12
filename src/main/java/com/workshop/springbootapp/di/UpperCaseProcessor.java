package com.workshop.springbootapp.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Primary
@Qualifier("someprocessor")
@Component
public class UpperCaseProcessor implements StringProcessor {

    @Override
    public String process(String entry) {
        if (entry == null) {
            return null;
        }

        return entry.toLowerCase();
    }
}

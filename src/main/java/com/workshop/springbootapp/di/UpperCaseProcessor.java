package com.workshop.springbootapp.di;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
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

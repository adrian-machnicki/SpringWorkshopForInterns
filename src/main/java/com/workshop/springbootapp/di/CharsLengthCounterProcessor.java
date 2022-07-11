package com.workshop.springbootapp.di;

import org.springframework.stereotype.Component;

@Component
public class CharsLengthCounterProcessor implements StringProcessor {

    @Override
    public String process(String entry) {
        if (entry == null) {
            return null;
        }

        return String.valueOf(entry.length());
    }
}

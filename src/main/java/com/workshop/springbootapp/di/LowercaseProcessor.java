package com.workshop.springbootapp.di;

import org.springframework.stereotype.Component;

//@Primary
@Component("defaultStringProcessor")
public class LowercaseProcessor implements StringProcessor {


    @Override
    public String process(String entry) {
        if (entry == null) {
            return null;
        }

        return entry.toLowerCase();
    }
}

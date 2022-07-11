package com.workshop.springbootapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean(name = "particularBean")
    public String particularBean() {
        return "particularBeansValue";
    }

}

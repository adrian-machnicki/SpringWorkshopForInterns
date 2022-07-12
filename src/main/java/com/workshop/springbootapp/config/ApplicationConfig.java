package com.workshop.springbootapp.config;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

import java.time.LocalDateTime;
import java.util.Random;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {

    @Value("${hello.service.mode}")
    String hellomode;

    @Bean(name = "particularBean")
    @Scope(SCOPE_SINGLETON)
    public int particularBean() {
        System.out.println("Value: " + hellomode);
        return new Random().nextInt(10000);
    }

    @Bean
    public LocalDateTime startDateTime() {
        return LocalDateTime.now();
    }

}

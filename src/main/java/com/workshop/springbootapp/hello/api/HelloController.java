package com.workshop.springbootapp.hello.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot app!!!!! Usability mode: ";
    }

    @GetMapping("/hello_personalised/{name}")
    public String helloPersonalised(@PathVariable String name) {
        return "Hello " + name.toUpperCase() + "!";
    }

    @GetMapping("/hello_internationalised")
    public String helloInternationalised(@RequestParam(defaultValue = "en") String lang) {

        return switch (lang.toLowerCase()) {
            case "en" -> "Hello world!";
            case "fi" -> "Hei maailma!";
            case "se" -> "Hej världen!";
            case "pl" -> "Witaj świecie!";
            case "it" -> "Ciao mondo!";
            default -> "Hello";
        };

    }
}

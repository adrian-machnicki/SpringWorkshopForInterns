package com.workshop.springbootapp;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Component
@Service
@Controller
public class ServiceComponent {

    public String greet() {
        return "Hello from ServiceComponent";
    }

}

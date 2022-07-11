package com.workshop.springbootapp;

import com.workshop.springbootapp.config.SecretServiceUserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootappApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootappApplication.class, args);

		System.out.println("== Hello in " + context.getApplicationName());
		System.out.println("== Environment: " + context.getEnvironment());
	}

}

package com.workshop.springbootapp;

import com.workshop.springbootapp.di.FirstnameConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootappApplication {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootappApplication.class, args);

//		var now = context.getBean("startDateTime", LocalDateTime.class);
//		System.out.println("Now: " + now);
//
//		var greeting = context.getBean(ServiceComponent.class);
//		System.out.println("Greeting:" + greeting.greet());

		var bean = context.getBean(FirstnameConverter.class);
		System.out.println("result: " + bean.convert("Adrian"));
	}

}

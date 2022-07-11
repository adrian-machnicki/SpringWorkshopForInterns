package com.workshop.springbootapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

class SpringbootappApplicationTests extends TestBase {

	@Autowired
	ApplicationContext appContext;

	@Test
	void contextLoads() {
		assertNotNull(appContext);
		assertEquals(1, appContext.getEnvironment().getActiveProfiles().length);
		assertEquals("test", appContext.getEnvironment().getActiveProfiles()[0]);
	}

}

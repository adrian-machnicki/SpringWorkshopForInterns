package com.workshop.springbootapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

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

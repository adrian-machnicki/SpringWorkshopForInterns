package com.workshop.springbootapp.hello.api;

import static org.hamcrest.Matchers.startsWithIgnoringCase;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.workshop.springbootapp.TestBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

class HelloControllerTest extends TestBase {

    private static final String HELLO_PATH = "/api/hello";

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldReturnHello() throws Exception {
        var req = get(HELLO_PATH);

        mvc.perform(req)
            .andExpect(status().isOk())
            .andExpect(content().string(startsWithIgnoringCase("hello")));
    }

}
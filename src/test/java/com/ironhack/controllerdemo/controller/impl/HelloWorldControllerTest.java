package com.ironhack.controllerdemo.controller.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloWorldControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void greaterWithRequestParams_NoParams_HelloWorld() throws Exception {
        MvcResult result = mockMvc.perform(get("/hello-world")).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("World"));

    }

    @Test
    void greaterWithRequestParams_WithParams_HelloParams() throws Exception {
        MvcResult result = mockMvc.perform(get("/hello-world?firstName=Víctor&lastName=Cardozo")).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Víctor"));
        assertTrue(result.getResponse().getContentAsString().contains("Cardozo"));
    }

    @Test
    void greaterWithPathVariable_ValidPath_HelloParam() throws Exception {
        MvcResult result = mockMvc.perform(get("/hello-world/Víctor").characterEncoding("UTF-8")).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Víctor"));
    }
}
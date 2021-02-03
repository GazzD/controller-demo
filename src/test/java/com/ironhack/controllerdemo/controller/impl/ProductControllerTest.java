package com.ironhack.controllerdemo.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.controllerdemo.enums.Category;
import com.ironhack.controllerdemo.enums.Department;
import com.ironhack.controllerdemo.model.Product;
import com.ironhack.controllerdemo.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ProductRepository productRepository;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Product product = new Product("La play 5", new BigDecimal("499.99"), Category.COMMERCIAL_NEW, Department.JEWELRY);
        Product product2 = new Product("La xbox series x", new BigDecimal("499.99"), Category.COMMERCIAL_NEW, Department.ART);

        productRepository.saveAll(List.of(product, product2));
    }

    @AfterEach
    void tearDown() {
        productRepository.deleteAll();
    }

    @Test
    void findAll_NoParams_AllProducts() throws Exception {
        MvcResult result = mockMvc.perform(get("/products")).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("play"));
        assertTrue(result.getResponse().getContentAsString().contains("xbox"));

    }

    @Test
    void store_Valid_Created() throws Exception {
        Product product = new Product("La Nintendo Switch", new BigDecimal("329.99"), Category.COMMERCIAL_NEW, Department.ELECTRONICS);
        String body = objectMapper.writeValueAsString(product);
        MvcResult result = mockMvc.perform(
                post("/products")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Nintendo"));


    }
}
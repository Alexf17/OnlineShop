package com.example.onlineshop.controller;

import com.example.onlineshop.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.Matchers.is;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/drop.sql")
@Sql("/create-tables-changelog.sql")
@Sql("/insert_test_data_changelog.sql")
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void showProductById() throws Exception {
        Product product = new Product();
        product.setName("XBOX SERIES X 1TB");
        product.setDescription("Kickstart your ultimate adventure with Xbox Series X and the Forza\n" +
                "Horizon 5 Premium Edition.");
        product.setId(UUID.fromString("32643131-6162-3831-2d66-6632372d3438"));

        MvcResult productResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/products/showProduct/32643131-6162-3831-2d66-6632372d3438")).andExpect(status().isOk()).andReturn();
        String productResultJSON = productResult.getResponse().getContentAsString();

        String productJSON = productResult.getResponse().getContentAsString();
        Product getResult = objectMapper.readValue(productResultJSON, Product.class);

        Assertions.assertEquals(product, getResult);
    }
}
package com.example.onlineshop.controller;

import com.example.onlineshop.controller.util.Generator;
import com.example.onlineshop.entity.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.Matchers.is;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        Product product = Generator.getProduct();

        MvcResult productResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/products/showProduct/32643131-6162-3831-2d66-6632372d3438")).andExpect(status().isOk()).andReturn();
        String productResultJSON = productResult.getResponse().getContentAsString();

        Product getResult = objectMapper.readValue(productResultJSON, Product.class);

        Assertions.assertEquals(product, getResult);
    }

    @Test
    void showAllProducts() throws Exception {
        Product product = Generator.getProduct();
        List<Product> productsList = Arrays.asList(product, product, product, product, product);

        MvcResult productResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/products/showProduct/all")).andExpect(status().isOk()).andReturn();
        String productResultJSON = productResult.getResponse().getContentAsString();
        List<Product> productList = objectMapper.readValue(productResultJSON, new TypeReference<List<Product>>() {
        });
        assertEquals(productsList.size(), productList.size());

    }

    @Test
    void deleteProductById() throws Exception {

        MvcResult productResultsBefore = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/products/showProduct/all")).andExpect(status().isOk()).andReturn();
        String productsResultJSONBefore = productResultsBefore.getResponse().getContentAsString();
        List<Product> productListBefore = objectMapper.readValue(productsResultJSONBefore, new TypeReference<List<Product>>() {
        });

        MockHttpServletResponse productDeleteResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/products/deleteProduct/32643131-6162-3831-2d66-6632372d3438"))
                .andExpect(status().isOk()).andReturn().getResponse();

        MvcResult productResultsAfter = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/products/showProduct/all")).andExpect(status().isOk()).andReturn();
        String productsResultJSONAfter = productResultsAfter.getResponse().getContentAsString();
        List<Product> productListAfter = objectMapper.readValue(productsResultJSONAfter, new TypeReference<List<Product>>() {
        });

        assertEquals(productListAfter.size(), productListBefore.size() - 1);
        assertEquals(productDeleteResult.getStatus(), HttpStatus.OK.value());
    }


}
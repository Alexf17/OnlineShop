package com.example.onlineshop.controller;

import com.example.onlineshop.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@Sql("/create-tables-changelog.sql")
@Sql("/insert_test_data_changelog.sql")
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void showProductById() throws Exception {
//        Product product = new Product();
//        product.setName("phone");
//        product.setId(UUID.fromString("683c5d2e-01e9-46e3-80d3-0c28a4a651ff"));
//
//        mockMvc
//                .perform(MockMvcRequestBuilders
//                        .get("/products/showProduct/2208b004-f622-41cd-85e8-6ed5c6df515d"))
//                .andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.p_id",is(product.getId().toString())));

//        MvcResult productResult = mockMvc
//                .perform(MockMvcRequestBuilders
//                        .get("/products/showProduct/b49a520a-59f4-43ed-a207-39b03184744e")).andExpect(status().isOk()).andReturn();
//        String productResultJSON = productResult.getResponse().getContentAsString();
//        System.out.println("*********************");
//        System.out.println(productResultJSON);
//        System.out.println("*********************");
//        String productJSON = productResult.getResponse().getContentAsString();
//        Product getResult = objectMapper.readValue(productResultJSON, Product.class);
//        System.out.println(getResult);
//        System.out.println("*********************");
////        Assertions.assertEquals(200, userResult.getResponse().getStatus());
//        Assertions.assertEquals(user1.getId(), authorResult.getId());
    }
}
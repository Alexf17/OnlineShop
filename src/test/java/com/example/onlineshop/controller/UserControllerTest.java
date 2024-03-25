package com.example.onlineshop.controller;

import com.example.onlineshop.entity.User;
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

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Sql("/create-tables-changelog.sql")
@Sql("/insert_test_data_changelog.sql")
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getUserById() throws Exception {
        User user1 = new User();
        user1.setId(UUID.fromString(
                "39336334-6165-6535-2d30-3739652d3438"));

        MvcResult userResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/user/showUser/39336334-6165-6535-2d30-3739652d3438")).andExpect(status().isOk()).andReturn();
        String userResultJSON = userResult.getResponse().getContentAsString();
        User authorResult = objectMapper.readValue(userResultJSON, User.class);

        Assertions.assertEquals(user1.getId(), authorResult.getId());

    }

}
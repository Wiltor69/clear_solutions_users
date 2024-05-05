package com.wiltor.clearsolutions.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.wiltor.clearsolutions.model.Users;

import com.wiltor.clearsolutions.service.UsersServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.List;


import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
//@RunWith(SpringRunner.class)

class UsersControllerTest {

    @Mock
    private UsersServiceImp usersService;
    @InjectMocks
    private UsersController usersController;
//    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        UsersController usersController = new UsersController(usersService);
        mockMvc = MockMvcBuilders.standaloneSetup(usersController).build();
    }

    @Test
    void findAllUsers() throws Exception{
        when(usersService.findAllUsers()).thenReturn(List.of(new Users("test@mail.com", "test",
                "test", LocalDate.of(2011,11,10),
                "Kyiv", "23875")));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    void findAllYear() throws Exception {
        when(usersService.findAllYear(anyInt(), anyInt())).thenReturn(List.of(new Users("test@mail.com", "test",
                "test", LocalDate.of(1991,11,10),
                "Kyiv", "23875")));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/25/37"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    void saveUser() throws Exception{
        Users users = new Users("test@mail.com", "test",
        "test", LocalDate.of(1991,11,10),
        "Kyiv", "23875");

        String requestBody = objectMapper.writeValueAsString(users);

        when(usersService.saveUser(any())).thenReturn(users);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/sign")
                        .content(requestBody)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void updateUser() throws Exception{
        Users users = new Users("test@mail.com", "test",
                "test", LocalDate.of(1991,11,10),
                "Kyiv", "23875");


        String requestBody = objectMapper.writeValueAsString(users);
        when(usersService.updateUser(any())).thenReturn(users);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/api/users/update/")
                        .content(requestBody)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }


}
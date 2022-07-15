package com.room1.demo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.room1.demo.models.Console;
import com.room1.demo.repositories.ConsoleRepository;
import com.room1.demo.service.ConsoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsoleService consoleService;
    @MockBean
    ConsoleRepository consoleRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void ShouldReturnConsole() throws Exception{

        List<Console> expectedConsole = new ArrayList<>(Arrays.asList(new Console(2,"PlayStation Portable","sega","2MB","AMD",new BigDecimal("20.99"),5)));
        Mockito.when(consoleService.findAllConsoles()).thenReturn(expectedConsole);
        String expectedJson = mapper.writeValueAsString(expectedConsole);

        mockMvc.perform(get("/consoles")) //Act
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJson));
    }

}
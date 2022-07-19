package com.room1.JGEBMA.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.room1.JGEBMA.models.Console;
import com.room1.JGEBMA.repositories.ConsoleRepository;
import com.room1.JGEBMA.service.ConsoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
    public void ShouldReturnConsoles() throws Exception{

        List<Console> expectedConsole = new ArrayList<>(Arrays.asList(new Console(2,"PlayStation Portable","sega","2MB","AMD",new BigDecimal("20.99"),5)));
        Mockito.when(consoleService.findAllConsoles()).thenReturn(expectedConsole);
        String expectedJson = mapper.writeValueAsString(expectedConsole);

        mockMvc.perform(get("/consoles")) //Act
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJson));
    }

    @Test
    public void ShouldReturnConsolesByManufacturer() throws Exception{

        List<Console> expectedConsole = new ArrayList<>(Arrays.asList(new Console(2,"PlayStation Portable","sega","2MB","AMD",new BigDecimal("20.99"),5),
                new Console(3,"PlayStation Portable","sega","2MB","AMD",new BigDecimal("20.99"),5),
                new Console(4,"PlayStation Portable","sega","2MB","AMD",new BigDecimal("20.99"),5)));
        Mockito.when(consoleService.findAllConsolesByManufacturer("sega")).thenReturn(expectedConsole);
        String expectedJson = mapper.writeValueAsString(expectedConsole);

        mockMvc.perform(get("/consoles?manufacturer=sega")) //Act
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJson));
    }


    @Test
    public void ShouldReturnConsoleById() throws Exception{

        Console expectedConsole = new Console(2,"PlayStation Portable","sega","2MB","AMD",new BigDecimal("20.99"),5);
        Mockito.when(consoleService.findConsoleById(2)).thenReturn(expectedConsole);
        String expectedJson = mapper.writeValueAsString(expectedConsole);

        mockMvc.perform(get("/consoles/2")) //Act
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJson));
    }

    @Test
    public void ShouldReturn422UProcessableWhenSearchingConsoleByIdWithAwrongEntryType() throws Exception{
        mockMvc.perform(get("/consoles/rt")) //Act
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

    }


    @Test
    public void ShouldDeleteConsoleById() throws Exception{


        mockMvc.perform(delete("/consoles/2")) //Act
                .andDo(print())
                .andExpect(status().isNoContent());

    }



    @Test
    public void ShouldReturn404NotFound() throws Exception{



        mockMvc.perform(get("/consles/1")) //Act  //miss-spelled url
                .andDo(print())
                .andExpect(status().isNotFound());

    }



    @Test
    public void ShouldCreateConsole() throws Exception{

        Console inputBody = new Console("PlayStation Portable","sega","2MB","AMD",new BigDecimal("20.99"),5);
        Console expectedConsole = new Console(1,"PlayStation Portable","sega","2MB","AMD",new BigDecimal("20.99"),5);
        Mockito.when(consoleService.saveConsole(inputBody)).thenReturn(expectedConsole);
        String expectedJson = mapper.writeValueAsString(expectedConsole);
        String inputJson = mapper.writeValueAsString(inputBody);

        mockMvc.perform(post("/consoles")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                //Act
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(expectedJson));
    }


}
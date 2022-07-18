package com.room1.demo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.room1.demo.models.Game;
import com.room1.demo.models.Shirt;
import com.room1.demo.repositories.GameRepository;
import com.room1.demo.repositories.ShirtRepository;
import com.room1.demo.service.GameService;
import com.room1.demo.service.ShirtService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ShirtController.class)
public class ShirtControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShirtService shirtService;
    @MockBean
    ShirtRepository shirtRepository;

    private ObjectMapper mapper = new ObjectMapper();


    @Test
    public void ShouldGetShirts() throws Exception {

        List<Shirt> expectedShirt = new ArrayList<>(Arrays.asList(
                new Shirt(1,"md","White","md white shirt",new BigDecimal("10.99"),5)));
        Mockito.when(shirtService.findAllShirts()).thenReturn(expectedShirt);
        String expectedJson = mapper.writeValueAsString(expectedShirt);

        mockMvc.perform(get("/shirts")) //Act
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJson));
    }

    @Test
    public void ShouldGetShirtsByColor() throws Exception {

        List<Shirt> expectedShirt = new ArrayList<>(Arrays.asList(
                new Shirt(1,"md","White","md white shirt",new BigDecimal("10.99"),5)));
        Mockito.when(shirtService.findAllShirtsByColor("white")).thenReturn(expectedShirt);
        String expectedJson = mapper.writeValueAsString(expectedShirt);

        mockMvc.perform(get("/shirts?color=white")) //Act
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJson));
    }

    @Test
    public void ShouldGetShirtsBySize() throws Exception {

        List<Shirt> expectedShirt = new ArrayList<>(Arrays.asList(
                new Shirt(1,"md","White","md white shirt",new BigDecimal("10.99"),5)));
        Mockito.when(shirtService.findAllShirtsBySize("md")).thenReturn(expectedShirt);
        String expectedJson = mapper.writeValueAsString(expectedShirt);

        mockMvc.perform(get("/shirts?size=md")) //Act
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJson));
    }

    @Test
    public void ShouldGetShirtsById() throws Exception {

        Shirt expectedShirt = new Shirt(1,"md","White","md white shirt",new BigDecimal("10.99"),5);
        Mockito.when(shirtService.findShirtById(1)).thenReturn(expectedShirt);
        String expectedJson = mapper.writeValueAsString(expectedShirt);

        mockMvc.perform(get("/shirts/1")) //Act
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJson));
    }

    @Test
    public void shouldCreateShirt() throws Exception{

        Shirt inputBody = new Shirt("md","White","md white shirt",new BigDecimal("10.99"),5);
        Shirt expectedShirt = new Shirt(1,"md","White","md white shirt",new BigDecimal("10.99"),5);
        Mockito.when(shirtService.saveShirt(inputBody));
        String expectedJson = mapper.writeValueAsString(expectedShirt);
        String inputJson = mapper.writeValueAsString(inputBody);

        mockMvc.perform(get("/shirts")) //Act
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(expectedJson));
    }

    @Test
    public void ShouldReturn422UProcessableWhenSearchingShirtByIdWithAwrongEntryType() throws Exception{
        mockMvc.perform(get("/shirts/rt")) //Act
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

    }

}
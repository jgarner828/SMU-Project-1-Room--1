package com.room1.JGEBMA.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.room1.JGEBMA.models.Game;
import com.room1.JGEBMA.repositories.GameRepository;
import com.room1.JGEBMA.service.GameService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;
    @MockBean
    GameRepository gameRepository;

    private ObjectMapper mapper = new ObjectMapper();


    @Test
    public void ShouldGetGames() throws Exception {

        List<Game> expectedGame = new ArrayList<>(Arrays.asList(new Game(1,"Dr. Mario",6,"Rescue the queen",new BigDecimal("9.99"),"Nintendo",5)));
        Mockito.when(gameService.findAllGames()).thenReturn(expectedGame);
        String expectedJson = mapper.writeValueAsString(expectedGame);

        mockMvc.perform(get("/games")) //Act
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJson));
    }

    @Test
    public void ShouldGetGamesByTitle() throws Exception {

        List<Game> expectedGame = new ArrayList<>(Arrays.asList(new Game(1,"Dr. Mario",6,"Rescue the queen",new BigDecimal("9.99"),"Nintendo",5)));
        Mockito.when(gameService.findGamesByTitle("Dr. Mario")).thenReturn(expectedGame);
        String expectedJson = mapper.writeValueAsString(expectedGame);

        mockMvc.perform(get("/games?title=Dr. Mario")) //Act
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJson));
    }







    @Test
    public void ShouldGetGameById() throws Exception{

        Game expectedGame = new Game(1,"Dr. Mario",6,"Rescue the queen",new BigDecimal("9.99"),"Nintendo",5);
        Mockito.when(gameService.findGame(1)).thenReturn(expectedGame);
        String expectedJson = mapper.writeValueAsString(expectedGame);

        mockMvc.perform(get("/games/1")) //Act
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJson));
    }

    @Test
    public void shouldCreateGame() throws Exception{

        Game inputBody = new Game("Dr. Mario",6,"Rescue the queen",new BigDecimal("9.99"),"Nintendo",5);
        Game expectedGame = new Game(1,"Dr. Mario",6,"Rescue the queen",new BigDecimal("9.99"),"Nintendo",5);
        Mockito.when(gameService.saveGame(inputBody)).thenReturn(expectedGame);
        String expectedJson = mapper.writeValueAsString(expectedGame);
        String inputJson = mapper.writeValueAsString(inputBody);

        mockMvc.perform(post("/games")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                //Act
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(expectedJson));
    }

    @Test
    public void updateGame() {
    }

    @Test
    public void deleteGame() {
    }
}
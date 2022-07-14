package com.room1.demo.controllers;

import com.room1.demo.models.Game;
import com.room1.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/games")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGames(){
        return gameService.findAllGames();
    }

    @GetMapping("/games/{id}")
    public Game getGameById(@PathVariable int id) {
        return gameService.findGame(id);
    }

    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game addGame(@RequestBody @Valid Game game) {
        return gameService.saveGame(game);
    }


    @PutMapping("/games")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody @Valid Game game) {
        gameService.updateGame(game);
    }

    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {
        gameService.deleteGame(id);
    }


}

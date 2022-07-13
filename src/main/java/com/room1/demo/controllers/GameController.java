package com.room1.demo.controllers;

import com.room1.demo.service.GameService;
import com.room1.demo.viewmodel.ConsoleViewModel;
import com.room1.demo.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/games")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGames(){
        return gameService.findAllGames();
    }


    @GetMapping("/games/{id}")
    public GameViewModel getGameById(@PathVariable int id) {
        return gameService.findGame(id);
    }
    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel addGame(@RequestBody GameViewModel gameViewModel) {
        return gameService.saveGame(gameViewModel);
    }

    @PutMapping("/games")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody GameViewModel gameViewModel) {
        gameService.updateGame(gameViewModel);
    }

    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {
        gameService.deleteGame(id);
    }


}

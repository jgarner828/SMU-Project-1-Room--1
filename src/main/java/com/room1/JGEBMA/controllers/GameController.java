package com.room1.JGEBMA.controllers;

import com.room1.JGEBMA.models.Game;
import com.room1.JGEBMA.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;


@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @CrossOrigin()
    @GetMapping("/games")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGames(@PathParam("studio") String studio,
                               @PathParam("esrb") Integer esrb,
                               @PathParam("title") String title){
        if (studio==null && esrb == null && title==null) {
            return gameService.findAllGames();
        } else if(studio==null && esrb == null){
            return gameService.findGamesByTitle(title);
        }else if(studio==null && title == null){
            return gameService.findGamesByEsrbRating(esrb);
        } else if(esrb==null && title == null) {
            return gameService.findGamesByStudio(studio);
        }
        return null;
    }

    @CrossOrigin()
    @GetMapping("/games/{id}")
    public Game getGameById(@PathVariable int id) {
        return gameService.findGame(id);
    }

    @CrossOrigin()
    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game addGame(@RequestBody @Valid Game game) {
        return gameService.saveGame(game);
    }

    @CrossOrigin()
    @PutMapping("/games")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody @Valid Game game) {
        gameService.updateGame(game);
    }

    @CrossOrigin()
    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {
        gameService.deleteGame(id);
    }


}

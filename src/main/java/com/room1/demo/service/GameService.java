package com.room1.demo.service;

import com.room1.demo.models.Game;
import com.room1.demo.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;


    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    public Game findGame(int id) {
        // Get the album object first
        Optional<Game> game = gameRepository.findById(id);
        return game.isPresent() ? game.get() : null;
    }

    public List<Game> findAllGames() {
      return gameRepository.findAll();
    }

    @Transactional
    public Game saveGame(Game game) { gameRepository.save(game); return game; }


    @Transactional
    public void updateGame(Game game) {
        gameRepository.save(game);
    }


    @Transactional
    public void deleteGame(int id) {  gameRepository.deleteById(id);  }

    public List<Game> findGamesByStudio(String studio){
        return gameRepository.findGamesByStudio(studio);
    }
    public List<Game> findGamesByEsrbRating(int esrb) {
        return gameRepository.findGamesByEsrbRating(esrb);
    }

        public List<Game> findGamesByTitle(String title){
            return gameRepository.findGamesByTitle(title);
        }
    }




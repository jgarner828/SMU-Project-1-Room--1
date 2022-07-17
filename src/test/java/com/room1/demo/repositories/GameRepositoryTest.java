package com.room1.demo.repositories;

import com.room1.demo.models.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameRepositoryTest {

    @Autowired
    GameRepository gameRepository;

    @Before
    public void setUp() throws Exception {
        gameRepository.deleteAll();

        gameRepository.save(new Game(1, "PacMan", 5, "Eat things", BigDecimal.valueOf(10.00), "Pacman", 4));
        gameRepository.save(new Game(2, "Mrs PacMan", 5, "Eat things", BigDecimal.valueOf(14.00), "Pacman", 4));
        gameRepository.save(new Game(3, "Halo", 5, "Destroy alien things", BigDecimal.valueOf(104.00), "EA", 4));
        gameRepository.save(new Game(4, "Final Fantasy", 5, "Do things", BigDecimal.valueOf(10.00), "EA", 4));
        gameRepository.save(new Game(5, "World of Warcraft", 1, "Grind time away for nothing", BigDecimal.valueOf(10.00), "Blizzard", 4));

    }

    @Test
    public void findGamesByStudio() {
        List<Game> eaGames = gameRepository.findGamesByStudio("EA");
        assertEquals(eaGames.size(), 2);

    }

    @Test
    public void findGamesByEsrbRating() {
        List<Game> bestGames = gameRepository.findGamesByEsrbRating(5);
        assertEquals(bestGames.size(), 4);
    }

    @Test
    public void findGamesByTitle() {
        List<Game> bytitleGames = gameRepository.findGamesByTitle("Pacman");
        assertEquals(bytitleGames.size(), 1);
    }
}
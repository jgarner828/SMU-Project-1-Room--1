package com.room1.JGEBMA.models;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testThatYouCanCreateNewGameWithArgs() {
        Game testGame1 =
                new Game(1, "PacMan", 5, "Eat things", BigDecimal.valueOf(10.00), "Pacman", 4);
        Game testGame =
                new Game(1, "PacMan", 5, "Eat things", BigDecimal.valueOf(10.00), "Pacman", 4);

    assertEquals(testGame1,testGame);

    }
}
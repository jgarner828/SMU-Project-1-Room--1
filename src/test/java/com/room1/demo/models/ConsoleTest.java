package com.room1.demo.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {

    @Test
    public void testingThatYouCanCreateNewConsoleWithArgs() {

        Console test1 =
                new Console(1, "64", "Nintendo", "64kb", "AMD64",  BigDecimal.valueOf(19.99), 10);
        Console test2 =
                new Console(1, "64", "Nintendo", "64kb", "AMD64",  BigDecimal.valueOf(19.99), 10);

    assertEquals(test1, test2);
    }


}
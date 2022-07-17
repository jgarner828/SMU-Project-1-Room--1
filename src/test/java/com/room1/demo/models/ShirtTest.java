package com.room1.demo.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ShirtTest {

    @Test
    public void testThatYouCanCreateNewShirtWithArgs() {
        Shirt newShirt = new Shirt(1, "small", "white", "shirt", BigDecimal.valueOf(10.00), 10);
        Shirt newShirt2 = new Shirt(1, "small", "white", "shirt", BigDecimal.valueOf(10.00), 10);

        assertEquals(newShirt,newShirt2);
    }

}
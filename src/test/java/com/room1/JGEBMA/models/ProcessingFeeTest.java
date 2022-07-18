package com.room1.JGEBMA.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProcessingFeeTest {

    @Test
    public void testThatYouCanCreateNewProcessingFeeWithArgs() {

        ProcessingFee test1 = new ProcessingFee(1, "Consoles", BigDecimal.valueOf(15.99));
        ProcessingFee test2 = new ProcessingFee(1, "Consoles", BigDecimal.valueOf(15.99));

        assertEquals(test1, test2);
    }
}
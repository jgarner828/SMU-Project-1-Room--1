package com.room1.demo.viewmodel;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceViewModelTest {

    @Test
    public void testYouCanCreateNewInvoiceViewModel() {
        InvoiceViewModel test1 = new InvoiceViewModel(
                "Justin",
                "Peachtree St",
                "Atlanta",
                "GA",
                "30050",
                "shirts",
                4,
                BigDecimal.valueOf(9.99),
                4,
                BigDecimal.valueOf(9.99),
                BigDecimal.valueOf(9.99),
                BigDecimal.valueOf(9.99),
                BigDecimal.valueOf(9.99));


        InvoiceViewModel test2 = new InvoiceViewModel(
                "Justin",
                "Peachtree St",
                "Atlanta",
                "GA",
                "30050",
                "shirts",
                4,
                BigDecimal.valueOf(9.99),
                4,
                BigDecimal.valueOf(9.99),
                BigDecimal.valueOf(9.99),
                BigDecimal.valueOf(9.99),
                BigDecimal.valueOf(9.99));

        assertEquals(test1, test2);


    }
}
package com.room1.demo.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SalesTaxRateTest {


       @Test
        public void testThatYouCanCreateNewSalesTaxRateWithArgs() {
            SalesTaxRate test1 =
                    new SalesTaxRate(1, "GA", BigDecimal.valueOf(0.55));

            SalesTaxRate test2 =
                    new SalesTaxRate(1, "GA", BigDecimal.valueOf(0.55));

        assertEquals(test1,test2);

    }

}
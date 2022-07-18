package com.room1.JGEBMA.repositories;

import com.room1.JGEBMA.models.SalesTaxRate;
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
public class SalesTaxRateRepositoryTest {

    @Autowired
    SalesTaxRateRepository salesTaxRateRepository;

    @Before
    public void setUp() throws Exception {
        salesTaxRateRepository.deleteAll();

        salesTaxRateRepository.save(new SalesTaxRate(1, "GA", BigDecimal.valueOf(0.55)));
        salesTaxRateRepository.save(new SalesTaxRate(2, "FL", BigDecimal.valueOf(0.15)));
        salesTaxRateRepository.save(new SalesTaxRate(3, "NY", BigDecimal.valueOf(0.45)));
        salesTaxRateRepository.save(new SalesTaxRate(4, "LA", BigDecimal.valueOf(0.55)));
        salesTaxRateRepository.save(new SalesTaxRate(5, "IL", BigDecimal.valueOf(0.25)));
    }

    @Test
    public void findAllSalesTaxRateByState() throws Exception {

        List<SalesTaxRate> georgiaRates = salesTaxRateRepository.findAllSalesTaxRateByState("GA");
        assertEquals(1, georgiaRates.size());
    }
}
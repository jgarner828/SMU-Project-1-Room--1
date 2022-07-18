package com.room1.JGEBMA.service;

import com.room1.JGEBMA.models.SalesTaxRate;
import com.room1.JGEBMA.repositories.SalesTaxRateRepository;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class SalesTaxRateServiceTest {
    SalesTaxRateService salesTaxRateService;
    SalesTaxRateRepository salesTaxRateRepository;

    @Before
    public void setUp() throws Exception {
        setupSalesTaxRateRepositoryMock();
        salesTaxRateService = new SalesTaxRateService(salesTaxRateRepository);
        SalesTaxRate salesTaxRate2 = new SalesTaxRate();
        salesTaxRate2.setId(1);
        salesTaxRate2.setState("OH");
        salesTaxRate2.setRate(BigDecimal.valueOf(0.049));

        System.out.println("SalesTaxRateRepository.save(salesTaxRate) will return " + salesTaxRateRepository.save(salesTaxRate2));
        System.out.println("SalesTaxRateRepository.findById(salesTaxRate) will return " + salesTaxRateRepository.findById(1));
        System.out.println("SalesTaxRateRepository.findAll(salesTaxRate) will return " + salesTaxRateRepository.findAll());
    }

    @Test
    public void justRunTheSetUp() {
        System.out.println("Placeholder");
    }

    private void setupSalesTaxRateRepositoryMock() {
        salesTaxRateRepository = mock(SalesTaxRateRepository.class);

        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setId(1);
        salesTaxRate.setState("OH");
        salesTaxRate.setRate(BigDecimal.valueOf(0.049));


        SalesTaxRate salesTaxRate2 = new SalesTaxRate();
        salesTaxRate2.setId(1);
        salesTaxRate2.setState("OH");
        salesTaxRate2.setRate(BigDecimal.valueOf(0.049));

        List<SalesTaxRate> inList = new ArrayList<>();
        inList.add(salesTaxRate);

        doReturn(salesTaxRate).when(salesTaxRateRepository).save(salesTaxRate2);
        doReturn(Optional.of(salesTaxRate)).when(salesTaxRateRepository).findById(1);
        doReturn(inList).when(salesTaxRateRepository).findAll();

    }

}
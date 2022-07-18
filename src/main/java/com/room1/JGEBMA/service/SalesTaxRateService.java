package com.room1.JGEBMA.service;

import com.room1.JGEBMA.models.SalesTaxRate;
import com.room1.JGEBMA.repositories.SalesTaxRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesTaxRateService {
    @Autowired
    private SalesTaxRateRepository salesTaxRateRepository;

    @Autowired
    public SalesTaxRateService(SalesTaxRateRepository salesTaxRateRepository) {
        this.salesTaxRateRepository = salesTaxRateRepository;
    }

    public List<SalesTaxRate> getAllSalesTaxRate() {
        return salesTaxRateRepository.findAll();
    }

    public List<SalesTaxRate> findAllSalesTaxRateByState(String state) {return salesTaxRateRepository.findAllSalesTaxRateByState(state);}



}




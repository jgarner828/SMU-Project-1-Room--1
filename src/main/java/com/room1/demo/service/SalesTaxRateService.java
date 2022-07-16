package com.room1.demo.service;

import com.room1.demo.models.ProcessingFee;
import com.room1.demo.models.SalesTaxRate;
import com.room1.demo.repositories.GameRepository;
import com.room1.demo.repositories.ProcessingFeeRepository;
import com.room1.demo.repositories.SalesTaxRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

}




package com.room1.demo.service;

import com.room1.demo.models.ProcessingFee;
import com.room1.demo.models.SalesTaxRate;
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

        public List<SalesTaxRate> getAllSalesTaxRate() {
            return salesTaxRateRepository.findAll();
        }

        public SalesTaxRate getSalesTaxRateById(int id) {
            Optional<SalesTaxRate> val = salesTaxRateRepository.findById(id);
            if (val.isPresent()) {
                return val.get();
            } else {
                return null;
            }
        }

        public void addSalesTaxRate(SalesTaxRate salesTaxRate) {
           try {
                salesTaxRateRepository.save(salesTaxRate);
            } catch (Exception e) {
                e.getMessage();
            }
        }

        public void updateSalesTaxRate(SalesTaxRate salesTaxRate) {
            salesTaxRateRepository.save(salesTaxRate);
        }

        public void deleteSalesTaxRate(int id) {
            salesTaxRateRepository.deleteById(id);
        }

        public List<SalesTaxRate>  getAllSalesTaxRateByState(String state) {
          return salesTaxRateRepository.findAllCustomersByState(state);
    }
}



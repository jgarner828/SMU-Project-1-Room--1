package com.room1.demo.controllers;

import com.room1.demo.models.ProcessingFee;
import com.room1.demo.models.SalesTaxRate;
import com.room1.demo.service.ProcessingFeeService;
import com.room1.demo.service.SalesTaxRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SalesTaxRateController {
    @Autowired
    private SalesTaxRateService salesTaxRateService;
    @GetMapping("/salestaxrate")
    @ResponseStatus(HttpStatus.OK)
    public List<SalesTaxRate> getallSalesTaxRate() {
        return salesTaxRateService.getAllSalesTaxRate();
    }

    @GetMapping("/salestaxrate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SalesTaxRate getSalesTaxRateById(@PathVariable int id){
        return salesTaxRateService.getSalesTaxRateById(id);
    }

    @GetMapping("/salestaxrate/state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public List<SalesTaxRate> getAllSalesTaxRateByState(@PathVariable String state){
        return salesTaxRateService.getAllSalesTaxRateByState(state);
    }

    @PostMapping("/salestaxrate")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSalesTaxRate(@RequestBody SalesTaxRate salesTaxRate){
        salesTaxRateService.addSalesTaxRate(salesTaxRate);
    }

    @PutMapping("/salestaxrate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProcessingFee(@RequestBody SalesTaxRate salesTaxRate){
        salesTaxRateService.updateSalesTaxRate(salesTaxRate);
    }

    @DeleteMapping ("/salestaxrate/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProcessingFee(@PathVariable int id){
        salesTaxRateService.deleteSalesTaxRate(id);
    }


}
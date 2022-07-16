package com.room1.demo.controllers;
import com.room1.demo.models.SalesTaxRate;
import com.room1.demo.service.SalesTaxRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class SalesTaxRateController {
    @Autowired
    private SalesTaxRateService salesTaxRateService;
    @GetMapping("/salestaxrate")
    @ResponseStatus(HttpStatus.OK)
    public List<SalesTaxRate> getallSalesTaxRate(@PathParam("state") String state) {
        if(state == null) {
            return salesTaxRateService.getAllSalesTaxRate();
        }
        else return salesTaxRateService.findAllSalesTaxRateByState(state);
    }

}

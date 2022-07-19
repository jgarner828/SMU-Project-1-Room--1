package com.room1.JGEBMA.controllers;
import com.room1.JGEBMA.models.SalesTaxRate;
import com.room1.JGEBMA.service.SalesTaxRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
public class SalesTaxRateController {
    @Autowired
    private SalesTaxRateService salesTaxRateService;

    @CrossOrigin()
    @GetMapping("/salestaxrate")
    @ResponseStatus(HttpStatus.OK)
    public List<SalesTaxRate> getAllSalesTaxRate(@PathParam("state") String state) {
        if(state == null) {
            return salesTaxRateService.getAllSalesTaxRate();
        }
        else return salesTaxRateService.findAllSalesTaxRateByState(state);
    }

}

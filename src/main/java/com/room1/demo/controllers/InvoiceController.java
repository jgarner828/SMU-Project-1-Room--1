package com.room1.demo.controllers;

import com.room1.demo.models.Invoice;
import com.room1.demo.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/invoice")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getAllInvoices() {
        invoiceService
    }
}

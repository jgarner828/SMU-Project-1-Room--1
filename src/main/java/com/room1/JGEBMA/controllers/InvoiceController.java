package com.room1.JGEBMA.controllers;

import com.room1.JGEBMA.service.InvoiceService;
import com.room1.JGEBMA.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin()
@RestController
public class InvoiceController {

   @Autowired   
   InvoiceService invoiceService;

 @CrossOrigin()
    @GetMapping("/invoices")
    public List<InvoiceViewModel> getAllInvoices() {
        return invoiceService.findAllInvoiceViewModels();
    }

 @CrossOrigin()
    @GetMapping("/invoices/{id}")
    public InvoiceViewModel getInvoiceById(@PathVariable int id) { return invoiceService.findInvoice(id); }

 @CrossOrigin()
    @PostMapping("/invoices")
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel addInvoice(@RequestBody @Valid InvoiceViewModel viewModel) { return invoiceService.saveInvoice(viewModel);}

 @CrossOrigin()
    @PutMapping("/invoices")
    public void updateInvoice(@RequestBody @Valid InvoiceViewModel viewModel) { invoiceService.updateInvoice(viewModel); }

 @CrossOrigin()
    @DeleteMapping("/invoices/{id}")
    public void deleteInvoice(@PathVariable int id) { invoiceService.removeInvoice(id); }

 @CrossOrigin()
    @PostMapping("/purchaseInvoices")
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createPurchaseOrder(@RequestBody @Valid InvoiceViewModel viewModel) { return invoiceService.purchaseOrder(viewModel);}

}



package com.room1.demo.service;

import com.room1.demo.models.Console;
import com.room1.demo.models.Game;
import com.room1.demo.models.Invoice;
import com.room1.demo.models.Shirt;
import com.room1.demo.repositories.*;
import com.room1.demo.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class InvoiceService {


    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ConsoleRepository consoleRepository;
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ShirtRepository shirtRepository;

    @Autowired
    private ProcessingFeeRepository processingFeeRepository;
    @Autowired
    private SalesTaxRateRepository salesTaxRateRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel viewModel) {
        Invoice i = new Invoice();
        i.setInvoiceId(viewModel.getId());
        i.setName(viewModel.getName());
        i.setStreet(viewModel.getStreet());
        i.setCity(viewModel.getCity());
        i.setState(viewModel.getState());
        i.setItemType(viewModel.getItemType());
        i.setItemId(viewModel.getItemId());
        i.setUnitPrice(viewModel.getUnitPrice());
        i.setQuantity(viewModel.getQuantity());
        i.setSubtotal(viewModel.getSubtotal());
        i.setTax(viewModel.getTax());
        i.setProcessingFee(viewModel.getProcessingFee());
        i.setTotal(viewModel.getTotal());

        invoiceRepository.save(i);
        viewModel.setId(i.getInvoiceId());

        return viewModel;
    }


    public InvoiceViewModel findInvoice(int id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);

        return invoice.isPresent() ? buildInvoiceViewModel(invoice.get()) : null;

    }

    public List<InvoiceViewModel> findAllInvoiceViewModels() {
        List<Invoice> invoiceList = invoiceRepository.findAll();
        List<InvoiceViewModel> ivmList = new ArrayList<>();

        for (Invoice invoice : invoiceList) {
            InvoiceViewModel ivm = buildInvoiceViewModel(invoice);
            ivmList.add(ivm);
        }

        return ivmList;
    }

    @Transactional
    public void updateInvoice(InvoiceViewModel viewModel) {
        Invoice i = new Invoice();
        i.setInvoiceId(viewModel.getId());
        i.setName(viewModel.getName());
        i.setStreet(viewModel.getStreet());
        i.setCity(viewModel.getCity());
        i.setState(viewModel.getState());
        i.setItemType(viewModel.getItemType());
        i.setItemId(viewModel.getItemId());
        i.setUnitPrice(viewModel.getUnitPrice());
        i.setQuantity(viewModel.getQuantity());
        i.setSubtotal(viewModel.getSubtotal());
        i.setTax(viewModel.getTax());
        i.setProcessingFee(viewModel.getProcessingFee());
        i.setTotal(viewModel.getTotal());
        invoiceRepository.save(i);

    }

    public void removeInvoice(int id) {
        invoiceRepository.deleteById(id);
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setId(invoice.getInvoiceId());
        ivm.setName(invoice.getName());
        ivm.setStreet(invoice.getStreet());
        ivm.setCity(invoice.getCity());
        ivm.setState(invoice.getState());
        ivm.setItemType(invoice.getItemType());
        ivm.setItemId(invoice.getItemId());
        ivm.setUnitPrice(invoice.getUnitPrice());
        ivm.setQuantity(invoice.getQuantity());
        ivm.setSubtotal(invoice.getSubtotal());
        ivm.setTax(invoice.getTax());
        ivm.setProcessingFee(invoice.getProcessingFee());
        ivm.setTotal(invoice.getTotal());

        // Return the Invoice View Model
        return ivm;

    }

    public InvoiceViewModel purchaseOrder(@RequestBody InvoiceViewModel invoice) {

        InvoiceViewModel returnVal = new InvoiceViewModel();
        returnVal.setItemType(invoice.getItemType());
        returnVal.setItemId(invoice.getItemId());
        returnVal.setQuantity(invoice.getQuantity());

        if (returnVal.getItemType().equals("console")) {

            if (returnVal.getItemId() != null) {
                Optional<Console> consoleReturnVal = consoleRepository.findById(returnVal.getId());

                returnVal.setUnitPrice(consoleReturnVal.get().getPrice());

                if (consoleReturnVal.get().getQuantity() >= returnVal.getQuantity()) {
                    returnVal.setSubtotal(BigDecimal.valueOf(returnVal.getQuantity()).multiply(consoleReturnVal.get().getPrice()));
                    String customerState = invoice.getState();
                    Double taxRate = salesTaxRateRepository.findAllSalesTaxRateByState(customerState).getRate();
                    returnVal.setTax((returnVal.getSubtotal().multiply(BigDecimal.valueOf(taxRate))));
                    returnVal.setTotal(returnVal.getTax().add(returnVal.getSubtotal()));
                    return returnVal;

                }
                throw new IllegalArgumentException();

            }
            throw new IllegalArgumentException();


        } else if (invoice.getItemType().equals("game")) {
            returnVal.setItemType("game");
            if (returnVal.getItemId() != null) {
                Optional<Game> gameReturnVal = gameRepository.findById(returnVal.getId());

                returnVal.setUnitPrice(gameReturnVal.get().getPrice());

                if (gameReturnVal.get().getQuantity() >= returnVal.getQuantity()) {
                    returnVal.setSubtotal(BigDecimal.valueOf(returnVal.getQuantity()).multiply(gameReturnVal.get().getPrice()));
                    String customerState = invoice.getState();
                    Double taxRate = salesTaxRateRepository.findAllSalesTaxRateByState(customerState).getRate();
                    returnVal.setTax((returnVal.getSubtotal().multiply(BigDecimal.valueOf(taxRate))));
                    returnVal.setTotal(returnVal.getTax().add(returnVal.getSubtotal()));
                    return returnVal;

                }
                throw new IllegalArgumentException();

            }
            throw new IllegalArgumentException();


        } else if (invoice.getItemType() == "shirt") {
            returnVal.setItemType("shirt");

            if (returnVal.getItemId() != null) {
                Optional<Shirt> shirtReturnVal = shirtRepository.findById(returnVal.getId());

                returnVal.setUnitPrice(shirtReturnVal.get().getPrice());

                if (shirtReturnVal.get().getQuantity() >= returnVal.getQuantity()) {
                    returnVal.setSubtotal(BigDecimal.valueOf(returnVal.getQuantity()).multiply(shirtReturnVal.get().getPrice()));
                    String customerState = invoice.getState();
                    Double taxRate = salesTaxRateRepository.findAllSalesTaxRateByState(customerState).getRate();
                    returnVal.setTax((returnVal.getSubtotal().multiply(BigDecimal.valueOf(taxRate))));
                    returnVal.setTotal(returnVal.getTax().add(returnVal.getSubtotal()));
                    return returnVal;

                }
                throw new IllegalArgumentException();

            }
            throw new IllegalArgumentException();


        } else {
            throw new IllegalArgumentException();
        }


    }


}

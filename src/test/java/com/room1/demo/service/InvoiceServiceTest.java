package com.room1.demo.service;

import com.room1.demo.models.Invoice;
import com.room1.demo.repositories.InvoiceRepository;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class InvoiceServiceTest {

    InvoiceService invoiceService;
    InvoiceRepository invoiceRepository;

    @Before
    public void setUp() throws Exception {
        setUpInvoiceRepositoryMock();

        invoiceService = new InvoiceService(invoiceRepository);
        Invoice invoice2 = new Invoice();
        invoice2.setInvoiceId(1);
        invoice2.setName("John");
        invoice2.setStreet("222");
        invoice2.setCity("cincinnati");
        invoice2.setState("OH");
        invoice2.setZipcode("45238");
        invoice2.setItemType("Game");
        invoice2.setItemId(Integer.parseInt("22"));
        invoice2.setUnitPrice(new BigDecimal(25.00));
        invoice2.setQuantity(4);
        invoice2.setSubtotal(new BigDecimal(100.00));
        invoice2.setTax(new BigDecimal(0.04));
        invoice2.setProcessingFee(new BigDecimal(1.49));
        invoice2.setTotal(new BigDecimal(105.49));
        System.out.println("InvoiceRepository.save(invoice) will return " + invoiceRepository.save(invoice2));
        System.out.println("InvoiceRepository.findById(invoice) will return " + invoiceRepository.findById(1));
        System.out.println("InvoiceRepository.findByAll(invoice) will return " + invoiceRepository.findAll());
    }

    @Test
    public void justRunTheSetUp() {
        System.out.println("Placeholder");
    }

    private void setUpInvoiceRepositoryMock() {
        invoiceRepository = mock(InvoiceRepository.class);
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(1);
        invoice.setName("John");
        invoice.setStreet("222");
        invoice.setCity("cincinnati");
        invoice.setState("OH");
        invoice.setZipcode("45238");
        invoice.setItemType("Game");
        invoice.setItemId(Integer.parseInt("22"));
        invoice.setUnitPrice(new BigDecimal(25.00));
        invoice.setQuantity(4);
        invoice.setSubtotal(new BigDecimal(100.00));
        invoice.setTax(new BigDecimal(0.04));
        invoice.setProcessingFee(new BigDecimal(1.49));
        invoice.setTotal(new BigDecimal(105.49));

        Invoice invoice2 = new Invoice();
        invoice2.setInvoiceId(1);
        invoice2.setName("John");
        invoice2.setStreet("222");
        invoice2.setCity("cincinnati");
        invoice2.setState("OH");
        invoice2.setZipcode("45238");
        invoice2.setItemType("Game");
        invoice2.setItemId(Integer.parseInt("22"));
        invoice2.setUnitPrice(new BigDecimal(25.00));
        invoice2.setQuantity(4);
        invoice2.setSubtotal(new BigDecimal(100.00));
        invoice2.setTax(new BigDecimal(0.04));
        invoice2.setProcessingFee(new BigDecimal(1.49));
        invoice2.setTotal(new BigDecimal(105.49));

        List<Invoice> inList = new ArrayList<>();
        inList.add(invoice);

        doReturn(invoice).when(invoiceRepository).save(invoice2);
        doReturn(Optional.of(invoice)).when(invoiceRepository).findById(1);
        doReturn(inList).when(invoiceRepository).findAll();

    }
}
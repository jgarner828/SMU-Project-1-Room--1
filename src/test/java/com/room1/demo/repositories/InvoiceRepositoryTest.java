package com.room1.demo.repositories;

import com.room1.demo.models.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceRepositoryTest {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Before
    public void setUp() throws Exception {
        invoiceRepository.deleteAll();

        invoiceRepository.save(
                new Invoice(0,"Justin","Peachtree St","Atlanta","GA","30050","shirts",4,BigDecimal.valueOf(10.00),1,BigDecimal.valueOf(10.00),BigDecimal.valueOf(10.00),BigDecimal.valueOf(10.00), BigDecimal.valueOf(10.00)));
        invoiceRepository.save(
                new Invoice(2,"Meron","Peachtree St","Atlanta","GA","30050","shirts",4,BigDecimal.valueOf(10.00),1,BigDecimal.valueOf(10.00),BigDecimal.valueOf(10.00),BigDecimal.valueOf(10.00), BigDecimal.valueOf(10.00)));
        invoiceRepository.save(
                new Invoice(1,"Kyle","Peachtree St","Atlanta","GA","30050","shirts",4,BigDecimal.valueOf(10.00),1,BigDecimal.valueOf(10.00),BigDecimal.valueOf(10.00),BigDecimal.valueOf(10.00), BigDecimal.valueOf(10.00)));
    }

    @Test
    public void repoSavesNewInvoices() throws Exception {
        List<Invoice> invoices = invoiceRepository.findAll();
        assertEquals(3, invoices.size());
    }

}
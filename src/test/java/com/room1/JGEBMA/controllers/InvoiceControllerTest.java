package com.room1.JGEBMA.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.room1.JGEBMA.repositories.InvoiceRepository;
import com.room1.JGEBMA.service.InvoiceService;
import com.room1.JGEBMA.viewmodel.InvoiceViewModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InvoiceService invoiceService;
    @MockBean
    InvoiceRepository invoiceRepository;

    @MockBean
    InvoiceViewModel invoiceViewModel;

    private ObjectMapper mapper = new ObjectMapper();


    @Test
    public void shouldProcessPurchasedOrder() throws Exception{

        InvoiceViewModel inputBody = new InvoiceViewModel("Meron","Hopeland dr","Norcross","GA","30127","Game",1,new BigDecimal("9.99"),1);
        InvoiceViewModel expectedInvoice = new InvoiceViewModel("Meron","Hopeland dr","Norcross","GA","30127","Game",1,new BigDecimal("9.99"),1,new BigDecimal("9.99"),new BigDecimal("0.6993"),new BigDecimal("1.49"),new BigDecimal("12.1793"));
        Mockito.when(invoiceService.purchaseOrder(inputBody)).thenReturn(expectedInvoice);
        String expectedJson = mapper.writeValueAsString(expectedInvoice);
        String inputJson = mapper.writeValueAsString(inputBody);

        mockMvc.perform(post("/purchaseInvoices")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                //Act
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(expectedJson));
    }





}
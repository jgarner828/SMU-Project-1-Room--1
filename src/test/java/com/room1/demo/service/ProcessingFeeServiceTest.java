package com.room1.demo.service;

import com.room1.demo.models.ProcessingFee;
import com.room1.demo.models.SalesTaxRate;
import com.room1.demo.repositories.ProcessingFeeRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ProcessingFeeServiceTest {
    ProcessingFeeService processingFeeService;
    ProcessingFeeRepository processingFeeRepository;

    @Before
    public void setUp() throws Exception {
        setUpProcessingFeeRepositoryMock();
        processingFeeService = new ProcessingFeeService(processingFeeRepository);

        ProcessingFee processingFee2 = new ProcessingFee();
        processingFee2.setId(2);
        processingFee2.setProductType("Console");
        processingFee2.setFee(25.55);

        System.out.println("ProcessingFeeRepository.save(processingFee) will return " + processingFeeRepository.save(processingFee2));
        System.out.println("ProcessingFeeRepository.findById(processingFee) will return " + processingFeeRepository.findById(2));
        System.out.println("ProcessingFeeRepository.findAll(processingFee) will return " + processingFeeRepository.findAll());

    }

    @Test
    public void justRunTheSetUp() {
        System.out.println("Placeholder");
    }

    private void setUpProcessingFeeRepositoryMock() {
        processingFeeRepository = mock(ProcessingFeeRepository.class);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setId(2);
        processingFee.setProductType("Console");
        processingFee.setFee(25.55);


        ProcessingFee processingFee2 = new ProcessingFee();
        processingFee2.setId(2);
        processingFee2.setProductType("Console");
        processingFee2.setFee(25.55);

        List<ProcessingFee> inList = new ArrayList<>();
        inList.add(processingFee);

        doReturn(processingFee).when(processingFeeRepository).save(processingFee2);
        doReturn(Optional.of(processingFeeRepository)).when(processingFeeRepository).findById(2);
        doReturn(inList).when(processingFeeRepository).findAll();


    }

}
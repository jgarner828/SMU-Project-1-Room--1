package com.room1.JGEBMA.repositories;

import com.room1.JGEBMA.models.ProcessingFee;
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
public class ProcessingFeeRepositoryTest {

    @Autowired
    ProcessingFeeRepository processFeeRepository;

    @Before
    public void setUp() throws Exception {
        processFeeRepository.deleteAll();

        processFeeRepository.save(new ProcessingFee(1, "Consoles", BigDecimal.valueOf(15.99)));
        processFeeRepository.save(new ProcessingFee(2, "T-Shirts", BigDecimal.valueOf(1.99)));
        processFeeRepository.save(new ProcessingFee(3, "Games", BigDecimal.valueOf(1.99)));
    }

    @Test
    public void findProcessingFeeByProductTypeForGames () {
        List<ProcessingFee> findGameFees = processFeeRepository.findProcessingFeeByProductType("Games");
        assertEquals(1, findGameFees.size());
    }

    @Test
    public void findProcessingFeeByProductTypeForConsoles () {
        List<ProcessingFee> findGameFees = processFeeRepository.findProcessingFeeByProductType("Consoles");
        assertEquals(1, findGameFees.size());
    }

    @Test
    public void findProcessingFeeByProductTypeForTShirts () {
        List<ProcessingFee> findGameFees = processFeeRepository.findProcessingFeeByProductType("T-Shirts");
        assertEquals(1, findGameFees.size());
    }
}
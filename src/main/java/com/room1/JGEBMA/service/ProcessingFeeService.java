package com.room1.JGEBMA.service;
import com.room1.JGEBMA.models.ProcessingFee;
import com.room1.JGEBMA.repositories.ProcessingFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessingFeeService {
    @Autowired
    private ProcessingFeeRepository processingFeeRepository;

    public ProcessingFeeService(ProcessingFeeRepository processingFeeRepository) {
        this.processingFeeRepository = processingFeeRepository;
    }

    public List<ProcessingFee> getAllProcessingFees() {
        return processingFeeRepository.findAll();
    }

    public List<ProcessingFee> findProcessingFeeByProductType(String type) { return processingFeeRepository.findProcessingFeeByProductType(type); }


}

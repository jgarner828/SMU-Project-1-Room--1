package com.room1.demo.service;
import com.room1.demo.models.ProcessingFee;
import com.room1.demo.repositories.ProcessingFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

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

package com.room1.demo.service;

import com.room1.demo.models.ProcessingFee;
import com.room1.demo.repositories.InvoiceRepository;
import com.room1.demo.repositories.ProcessingFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProcessingFeeService {

    @Autowired
    private ProcessingFeeRepository processingFeeRepository;

    @Autowired
    public ProcessingFeeService(ProcessingFeeRepository processingFeeRepository) {
        this.processingFeeRepository = processingFeeRepository;
    }


    public List<ProcessingFee> getAllProcessingFees() {
       return processingFeeRepository.findAll();
    }

    public ProcessingFee getProcessingFeeById(int id) {
        Optional<ProcessingFee> val = processingFeeRepository.findById(id);
            if (val.isPresent()) {
                return val.get();
            } else {
                return null;
            }
        }


    public void addProcessingFee(ProcessingFee processingFee) {
        processingFeeRepository.save(processingFee);
    }

    public void updateProcessingFee(ProcessingFee processingFee) {
       processingFeeRepository.save(processingFee);
    }

    public void deleteProcessingFeeById(int id) {
        processingFeeRepository.deleteById(id);
    }

}

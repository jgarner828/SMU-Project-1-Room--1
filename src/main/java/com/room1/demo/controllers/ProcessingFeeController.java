package com.room1.demo.controllers;

import com.room1.demo.models.ProcessingFee;
import com.room1.demo.service.ProcessingFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProcessingFeeController {
    @Autowired
    private ProcessingFeeService processingFeeService;
    @GetMapping("/processingfees")
    @ResponseStatus(HttpStatus.OK)
    public List<ProcessingFee> getallprocessingfees() {
      return processingFeeService.getAllProcessingFees();
    }

    @GetMapping("/processingfees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProcessingFee getProcessingFeeById(@PathVariable int id){
        return processingFeeService.getProcessingFeeById(id);
    }

    @PostMapping("/processingfees")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProcessingFee(@RequestBody ProcessingFee processingFee){
        processingFeeService.addProcessingFee(processingFee);
    }

    @PutMapping("/processingfees")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProcessingFee(@RequestBody ProcessingFee processingFee){
         processingFeeService.updateProcessingFee(processingFee);
    }

    @DeleteMapping ("/processingfees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProcessingFee(@PathVariable int id){
        processingFeeService.deleteProcessingFeeById(id);
    }

}

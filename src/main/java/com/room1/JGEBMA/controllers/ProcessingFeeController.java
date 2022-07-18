package com.room1.JGEBMA.controllers;
import com.room1.JGEBMA.models.ProcessingFee;
import com.room1.JGEBMA.service.ProcessingFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin()
@RestController
public class ProcessingFeeController {
    @Autowired
    private ProcessingFeeService processingFeeService;
    @GetMapping("/processingfees")
    @ResponseStatus(HttpStatus.OK)
    public List<ProcessingFee> getallprocessingfees(@PathParam("type") String type) {
        if (type == null) { return processingFeeService.getAllProcessingFees(); }
        else return processingFeeService.findProcessingFeeByProductType(type);
    }


}

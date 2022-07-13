package com.room1.demo.controllers;

import com.room1.demo.service.ShirtService;
import com.room1.demo.viewmodel.ShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShirtController {

    @Autowired
    ShirtService shirtService;

    @GetMapping("/shirts")
    public List<ShirtViewModel> getAllShirts() {
        return shirtService.findAllShirtViewModels();
    }

    @GetMapping("/shirts/{id}")
    public ShirtViewModel getShirtById(@PathVariable int id) { return shirtService.findShirt(id); }

    @PostMapping("/shirts")
    @ResponseStatus(HttpStatus.CREATED)
    public ShirtViewModel addShirt(@RequestBody ShirtViewModel viewModel) { return shirtService.saveShirt(viewModel);}

    @PutMapping("/shirts")
    public void updateShirt(@RequestBody ShirtViewModel viewModel) { shirtService.updateShirt(viewModel); }

    @DeleteMapping("/shirts/{id}")
    public void deleteShirt(@PathVariable int id) { shirtService.removeShirt(id); }




}

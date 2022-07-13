package com.room1.demo.controllers;

import com.room1.demo.service.ShirtService;
import com.room1.demo.viewmodel.ShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ShirtController {

    @Autowired
    ShirtService shirtService;

    @GetMapping("/shirts")
    public List<ShirtViewModel> getAllShirts(@PathParam("color") String color, @PathParam("size") String size) {
        if (color==null && size == null){

        return shirtService.findAllShirtViewModels();
    }

        if(size == null){
            return shirtService.findAllShirtsByColor(color);

        }if(color == null){
            return shirtService.findAllShirtsBySize(size);

        }
        return null;
    }




    @GetMapping("/shirts/{id}")
    public ShirtViewModel getShirtById(@PathVariable int id) { return shirtService.findShirt(id); }

    @PostMapping("/shirts")
    @ResponseStatus(HttpStatus.CREATED)
    public ShirtViewModel addShirt(@RequestBody @Valid ShirtViewModel viewModel) { return shirtService.saveShirt(viewModel);}

    @PutMapping("/shirts")
    public void updateShirt(@RequestBody @Valid ShirtViewModel viewModel) { shirtService.updateShirt(viewModel); }

    @DeleteMapping("/shirts/{id}")
    public void deleteShirt(@PathVariable int id) { shirtService.removeShirt(id); }




}

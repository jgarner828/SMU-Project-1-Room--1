package com.room1.JGEBMA.controllers;

import com.room1.JGEBMA.models.Shirt;
import com.room1.JGEBMA.service.ShirtService;
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

    @CrossOrigin()
    @GetMapping("/shirts")
    public List<Shirt> getAllShirts(@PathParam("color") String color, @PathParam("size") String size) {
        if (color==null && size == null){

        return shirtService.findAllShirts();
    }

        if(size == null){
            return shirtService.findAllShirtsByColor(color);

        }if(color == null){
            return shirtService.findAllShirtsBySize(size);
        }
        return null;
    }

    @CrossOrigin()
    @GetMapping("/shirts/{id}")
    public Shirt getShirtById(@PathVariable int id) { return shirtService.findShirtById(id); }

    @CrossOrigin()
    @PostMapping("/shirts")
    @ResponseStatus(HttpStatus.CREATED)
    public Shirt addShirt(@RequestBody @Valid Shirt shirt) { return shirtService.saveShirt(shirt);}

    @CrossOrigin()
    @PutMapping("/shirts")
    public void updateShirt(@RequestBody @Valid Shirt shirt) { shirtService.updateShirt(shirt); }

    @CrossOrigin()
    @DeleteMapping("/shirts/{id}")
    public void deleteShirt(@PathVariable int id) { shirtService.removeShirt(id); }



}

package com.room1.demo.controllers;

import com.room1.demo.models.Console;
import com.room1.demo.service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ConsoleController {
    @Autowired
    ConsoleService consoleService;

    @GetMapping("/consoles")
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getConsoles(@PathParam("manufacturer") String manufacturer) {
        if (manufacturer == null) {
            return consoleService.findAllConsoles();
        } else return consoleService.findAllConsolesByManufacturer(manufacturer);
    }

    @GetMapping("/consoles/{id}")
    public Console getConsoleById(@PathVariable int id) {
        return consoleService.findConsoleById(id);
    }

    @PostMapping("/consoles")
    @ResponseStatus(HttpStatus.CREATED)
    public Console addConsole(@RequestBody  @Valid Console console) { return consoleService.saveConsole(console);  }

    @PutMapping("/consoles")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody @Valid Console console) {
        consoleService.updateConsole(console);
    }

    @DeleteMapping("/consoles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        consoleService.deleteConsole(id);
    }


}

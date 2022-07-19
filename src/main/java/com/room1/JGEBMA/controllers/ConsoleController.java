package com.room1.JGEBMA.controllers;

import com.room1.JGEBMA.models.Console;
import com.room1.JGEBMA.service.ConsoleService;
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

    @CrossOrigin()
    @GetMapping("/consoles")
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getConsoles(@PathParam("manufacturer") String manufacturer) {
        if (manufacturer == null) {
            return consoleService.findAllConsoles();
        } else return consoleService.findAllConsolesByManufacturer(manufacturer);
    }

    @CrossOrigin()
    @GetMapping("/consoles/{id}")
    public Console getConsoleById(@PathVariable int id) {
        return consoleService.findConsoleById(id);
    }

    @CrossOrigin()
    @PostMapping("/consoles")
    @ResponseStatus(HttpStatus.CREATED)
    public Console addConsole(@RequestBody  @Valid Console console) { return consoleService.saveConsole(console);  }

    @CrossOrigin()
    @PutMapping("/consoles")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody @Valid Console console) {
        consoleService.updateConsole(console);
    }

    @CrossOrigin()
    @DeleteMapping("/consoles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        consoleService.deleteConsole(id);
    }


}

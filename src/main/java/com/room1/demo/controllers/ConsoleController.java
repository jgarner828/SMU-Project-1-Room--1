package com.room1.demo.controllers;

import com.room1.demo.models.Console;
import com.room1.demo.service.ConsoleService;
import com.room1.demo.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ConsoleController {
    @Autowired
    ConsoleService consoleService;

    @GetMapping("/consoles")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsoles(){
        return consoleService.findAllConsoles();
    }

    @GetMapping("/consoles/{id}")
    public ConsoleViewModel getConsoleById(@PathVariable int id) {
        return consoleService.findConsoleById(id);
    }

    @PostMapping("/consoles")
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel addConsole(@RequestBody  @Valid ConsoleViewModel consoleviewModel) {
        return consoleService.saveConsole(consoleviewModel);
    }

    @PutMapping("/consoles")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody @Valid ConsoleViewModel consoleViewModel) {
        consoleService.updateConsole(consoleViewModel);
    }

    @DeleteMapping("/consoles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        consoleService.deleteConsole(id);
    }


}

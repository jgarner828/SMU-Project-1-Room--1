package com.room1.demo.service;

import com.room1.demo.models.Console;
import com.room1.demo.models.Game;
import com.room1.demo.repositories.ConsoleRepository;
import com.room1.demo.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsoleService {

    @Autowired
    private ConsoleRepository consoleRepository;

    @Autowired
    private GameRepository gameRepository;


    @Autowired
    public ConsoleService(ConsoleRepository consoleRepository) {
        this.consoleRepository = consoleRepository;
    }


    public Console findConsoleById(int id) {
        Optional<Console> console = consoleRepository.findById(id);
        return console.isPresent()? console.get() : null;
    }

    public List<Console> findAllConsoles() {
        return consoleRepository.findAll();
    }

    public List<Console> findAllConsolesByManufacturer(String manufacturer){  return consoleRepository.findConsoleByManufacturer(manufacturer);
    };

    @Transactional
    public Console saveConsole(Console console){
        consoleRepository.save(console);
        return console;

    }

    @Transactional
    public void updateConsole(Console console) {
        consoleRepository.save(console);
    }

    @Transactional
    public void deleteConsole(int id) {
       consoleRepository.deleteById(id);
    }

}
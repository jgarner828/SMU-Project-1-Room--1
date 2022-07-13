package com.room1.demo.service;

import com.room1.demo.models.Console;
import com.room1.demo.models.Game;
import com.room1.demo.repositories.ConsoleRepository;
import com.room1.demo.repositories.GameRepository;
import com.room1.demo.viewmodel.ConsoleViewModel;
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

    //@Transactional
    public ConsoleViewModel saveConsole(ConsoleViewModel viewModel){
        Console console = new Console();
        console.setManufacturer(viewModel.getManufacturer());
        console.setModel(viewModel.getModel());
        console.setMemoryAmount(viewModel.getMemoryAmount());
        console.setProcessor(viewModel.getProcessor());
        console.setPrice(viewModel.getPrice());
        console.setQuantity(viewModel.getQuantity());

        console=consoleRepository.save(console);

        viewModel.setId(console.getConsoleId());



        return viewModel;



    }

    public ConsoleViewModel findConsoleById(int id) {

        Optional<Console> console = consoleRepository.findById(id);

        return console.isPresent() ? buildConsoleViewModel(console.get()) : null;
    }

    private ConsoleViewModel buildConsoleViewModel(Console console) {


        Optional<Game> game = gameRepository.findById(console.getConsoleId());


        ConsoleViewModel consoleView = new ConsoleViewModel();
        consoleView.setId(console.getConsoleId());
        consoleView.setModel(console.getModel());
        consoleView.setManufacturer(console.getManufacturer());
        consoleView.setMemoryAmount(console.getMemoryAmount());
        consoleView.setProcessor(console.getProcessor());
        consoleView.setPrice(console.getPrice());
        consoleView.setQuantity(console.getQuantity());


        return consoleView;
    }


    public List<ConsoleViewModel> findAllConsoles() {

        List<Console> consoleList = consoleRepository.findAll();

        List<ConsoleViewModel> cvmList = new ArrayList<>();

        for (Console console : consoleList) {
            ConsoleViewModel cvm = buildConsoleViewModel(console);
            cvmList.add(cvm);
        }

        return cvmList;
    }


    @Transactional
    public void updateConsole(ConsoleViewModel viewModel) {

        // Update the album information
        Console console = new Console();
        console.setManufacturer(viewModel.getManufacturer());
        console.setModel(viewModel.getModel());
        console.setMemoryAmount(viewModel.getMemoryAmount());
        console.setProcessor(viewModel.getProcessor());
        console.setPrice(viewModel.getPrice());
        console.setQuantity(viewModel.getQuantity());
        consoleRepository.save(console);


    }

    @Transactional
    public void deleteConsole(int id) {


       consoleRepository.deleteById(id);

    }

}
package com.room1.demo.service;

import com.room1.demo.models.Game;
import com.room1.demo.repositories.GameRepository;
import com.room1.demo.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class GameService {
    private GameRepository gameRepository;

    @Autowired

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional
    public GameViewModel saveGame(GameViewModel viewModel) {
    Game g = new Game();
    g.setTitle(viewModel.getTitle());
    g.setEsrbRating(viewModel.getEsrbRating());
    g.setDescription(viewModel.getDescription());
    g.setPrice(viewModel.getPrice());
    g.setStudio(viewModel.getStudio());
    g.setQuantity(viewModel.getQuantity());

    viewModel.setId(g.getGameId());

    return viewModel;
    }

    public GameViewModel findGame(int id) {

        // Get the album object first
        Optional<Game> game = gameRepository.findById(id);

        return game.isPresent() ? buildGameViewModel(game.get()) : null;
    }

    private GameViewModel buildGameViewModel(Game game) {


        Optional<Game> artist = gameRepository.findById(game.getGameId());


        // Assemble the GameViewModel
        GameViewModel gvm = new GameViewModel();
        gvm.setId(game.getGameId());
        gvm.setTitle(game.getTitle());
        gvm.setEsrbRating(game.getEsrbRating());
        gvm.setDescription(game.getDescription());
        gvm.setPrice(game.getPrice());
        gvm.setQuantity(game.getQuantity());

        return gvm;
    }

    public List<GameViewModel> findAllGames() {

        List<Game> gameList = gameRepository.findAll();

        List<GameViewModel> gvmList = new ArrayList<>();

        for (Game game : gameList) {
            GameViewModel gvm = buildGameViewModel(game);
            gvmList.add(gvm);
        }

        return gvmList;
    }


    @Transactional
    public void updateGame(GameViewModel viewModel) {

        // Update the album information
        Game g = new Game();
        g.setTitle(viewModel.getTitle());
        g.setEsrbRating(viewModel.getEsrbRating());
        g.setDescription(viewModel.getDescription());
        g.setPrice(viewModel.getPrice());
        g.setStudio(viewModel.getStudio());
        g.setQuantity(viewModel.getQuantity());

        gameRepository.save(g);
    }

    @Transactional
    public void deleteGame(int id) {

        gameRepository.deleteById(id);

    }

}

package com.room1.JGEBMA.repositories;

import com.room1.JGEBMA.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game ,Integer> {

    List<Game> findGamesByStudio(String studio);
    List<Game> findGamesByEsrbRating(int esrb);
    List<Game> findGamesByTitle(String title);
}

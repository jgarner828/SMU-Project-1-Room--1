package com.room1.JGEBMA.repositories;

import com.room1.JGEBMA.models.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Integer> {
    public List<Console> findConsoleByManufacturer(String manufacturer);
}

package com.room1.JGEBMA.repositories;

import com.room1.JGEBMA.models.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShirtRepository extends JpaRepository<Shirt, Integer> {
    List<Shirt> findAllShirtsByColor(String color);
    List<Shirt> findAllShirtsBySize(String size);
}

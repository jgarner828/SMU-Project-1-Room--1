package com.room1.demo.repositories;

import com.room1.demo.models.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShirtRepository extends JpaRepository<Shirt, Integer> {
    List<Shirt> findAllShirtsByColor(String color);
    List<Shirt> findAllShirtsBySize(String size);
}

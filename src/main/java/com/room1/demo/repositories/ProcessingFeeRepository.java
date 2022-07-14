package com.room1.demo.repositories;

import com.room1.demo.models.ProcessingFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProcessingFeeRepository extends JpaRepository<ProcessingFee, Integer> {
    List<ProcessingFee> findProcessingFeeByCategory(String productType);
}

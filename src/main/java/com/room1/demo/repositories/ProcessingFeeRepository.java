package com.room1.demo.repositories;

import com.room1.demo.models.ProcessingFee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessingFeeRepository extends JpaRepository<ProcessingFee, Integer> {
}

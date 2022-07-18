package com.room1.JGEBMA.repositories;
import com.room1.JGEBMA.models.ProcessingFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProcessingFeeRepository extends JpaRepository<ProcessingFee, Integer> {
     List<ProcessingFee> findProcessingFeeByProductType(String productType);
}

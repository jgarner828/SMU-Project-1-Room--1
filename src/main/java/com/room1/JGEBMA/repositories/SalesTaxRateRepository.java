package com.room1.JGEBMA.repositories;
import com.room1.JGEBMA.models.SalesTaxRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesTaxRateRepository extends JpaRepository<SalesTaxRate,Integer> {

    List<SalesTaxRate> findAllSalesTaxRateByState(String state);

}

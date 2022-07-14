package com.room1.demo.repositories;
import com.room1.demo.models.SalesTaxRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesTaxRateRepository extends JpaRepository<SalesTaxRate,Integer> {
    SalesTaxRate findAllSalesTaxRateByState(String state);
}

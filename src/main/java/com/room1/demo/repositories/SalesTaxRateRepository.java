package com.room1.demo.repositories;

import com.room1.demo.models.SalesTaxRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesTaxRateRepository extends JpaRepository<SalesTaxRate,Integer> {
}

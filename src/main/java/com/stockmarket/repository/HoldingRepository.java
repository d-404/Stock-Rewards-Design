package com.stockmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmarket.entity.Holding;
import com.stockmarket.entity.HoldingKey;

public interface HoldingRepository extends JpaRepository<Holding, HoldingKey> {
}

package com.stockmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmarket.entity.Holding;
import com.stockmarket.entity.HoldingKey;

@Repository
public interface HoldingRepository extends JpaRepository<Holding, HoldingKey> {
}

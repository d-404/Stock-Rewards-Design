package com.stockmarket.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmarket.entity.Price;

public interface PriceRepository extends JpaRepository<Price, UUID> {
	Optional<Price> findFirstBySymbolOrderByFetchedAtDesc(String symbol);
}

package com.stockmarket.repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmarket.entity.DailyValuation;

public interface DailyValuationRepositiry extends JpaRepository<DailyValuation, UUID>{
	 Optional<DailyValuation> findByUserIdAndDate(UUID userId, LocalDate date);
}

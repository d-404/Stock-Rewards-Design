package com.stockmarket.repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmarket.entity.DailyValuation;

@Repository
public interface DailyValuationRepository extends JpaRepository<DailyValuation, UUID>{
	 Optional<DailyValuation> findByUserIdAndDate(UUID userId, LocalDate date);
}

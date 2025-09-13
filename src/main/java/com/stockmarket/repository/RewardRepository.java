package com.stockmarket.repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmarket.entity.Reward;

public interface RewardRepository extends JpaRepository<Reward, UUID> {
	List<Reward> findByUserIdAndAwardedAtBetween(UUID userId, OffsetDateTime from, OffsetDateTime to);
}

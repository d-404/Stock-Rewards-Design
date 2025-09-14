package com.stockmarket.service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmarket.dto.HoldingDto;
import com.stockmarket.entity.Holding;
import com.stockmarket.entity.HoldingKey;
import com.stockmarket.entity.Reward;
import com.stockmarket.repository.HoldingRepository;

@Service
public class HoldingService {
	private final HoldingRepository holdingRepository;

	public HoldingService(HoldingRepository holdingRepository) {
		this.holdingRepository = holdingRepository;
	}

	@Transactional
	public void addOrUpdateHolding(Reward reward) {
		HoldingKey holdingKey = new HoldingKey(reward.getUserId(), reward.getSymbol());
		Optional<Holding> holdingOptional = holdingRepository.findById(holdingKey);
		Holding holdings = holdingOptional.orElse(new Holding());
		holdings.setId(holdingKey);
		BigDecimal newShares = holdings.getShares().add(reward.getShares());
		holdings.setShares(newShares);
		BigDecimal newCost = holdings.getAvgCostInr().add(reward.getTotalInr());
		holdings.setAvgCostInr(newCost);
		holdings.setUpdatedAt(OffsetDateTime.now());
		holdingRepository.save(holdings);
	}

	public HoldingDto getHolding(HoldingKey key) {
		return holdingRepository.findById(key).map(h -> new HoldingDto(h.getId().getUserId(), h.getId().getSymbol(),
				h.getShares(), h.getShares(), h.getUpdatedAt())).orElse(null);
	}

}

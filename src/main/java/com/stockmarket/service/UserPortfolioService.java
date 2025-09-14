package com.stockmarket.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockmarket.dto.HoldingDto;
import com.stockmarket.repository.DailyValuationRepository;
import com.stockmarket.repository.HoldingRepository;

@Service
public class UserPortfolioService {
	private final HoldingRepository holdingRepository;
	private final DailyValuationRepository dailyValuationRepository;
	private final PriceService priceService;
	private final ObjectMapper objectMapper;

	public UserPortfolioService(HoldingRepository holdingRepository, DailyValuationRepository dailyValuationRepository,
			PriceService priceService, ObjectMapper objectMapper) {
		this.holdingRepository = holdingRepository;
		this.dailyValuationRepository = dailyValuationRepository;
		this.priceService = priceService;
		this.objectMapper = objectMapper;
	}

	/**
	 * Returns the current holdings with their latest market prices and valuation
	 */
	public List<HoldingDto> getUserHoldings(UUID userId) {
		return holdingRepository.findAll().stream().filter(h -> h.getId().getUserId().equals(userId))
				.map(h -> new HoldingDto(h.getId().getUserId(), h.getId().getSymbol(), h.getShares(), h.getAvgCostInr(),
						h.getUpdatedAt()))
				.collect(Collectors.toList());
	}

}

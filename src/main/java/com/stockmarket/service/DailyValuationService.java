package com.stockmarket.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockmarket.dto.DailyValuationDto;
import com.stockmarket.entity.DailyValuation;
import com.stockmarket.repository.DailyValuationRepository;

@Service
public class DailyValuationService {
	private final DailyValuationRepository dailyValuationRepository;
	private final ObjectMapper objectMapper;

	public DailyValuationService(DailyValuationRepository dailyValuationRepository, ObjectMapper objectMapper) {
		this.dailyValuationRepository = dailyValuationRepository;
		this.objectMapper = objectMapper;
	}

	@Transactional(readOnly = true)
	public DailyValuationDto getValuation(UUID userId, LocalDate date) {
		Optional<DailyValuation> dailyValuationOptional = dailyValuationRepository.findByUserIdAndDate(userId, date);
		return dailyValuationOptional.map(v -> {
			Map<String, BigDecimal> bySymbol = null;
			try {
				if (v.getBySymbol() != null) {
					bySymbol = objectMapper.readValue(v.getBySymbol(), new TypeReference<Map<String, BigDecimal>>() {
					});
				}
			} catch (IOException e) {
				throw new RuntimeException("Failed to parse bySymbol JSON", e);
			}
			return new DailyValuationDto(v.getUserId(), v.getDate(), v.getTotalInr(), bySymbol);
		}).orElse(null);
	}
}

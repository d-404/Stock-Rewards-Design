package com.stockmarket.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

public record DailyValuationDto(UUID userId, LocalDate date, BigDecimal totalInr, Map<String, BigDecimal> bySymbol) {
}
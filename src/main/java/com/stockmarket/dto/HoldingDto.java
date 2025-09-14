package com.stockmarket.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record HoldingDto(UUID userId, String symbol, BigDecimal shares, BigDecimal avgCostInr,
		OffsetDateTime updatedAt) {
}
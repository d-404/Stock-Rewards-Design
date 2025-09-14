package com.stockmarket.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record LedgerEntryDto(UUID userId, String account, BigDecimal amountInr, String type, String referenceId,
		OffsetDateTime createdAt) {
}
package com.stockmarket.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record RewardRequest(UUID userId, String symbol, BigDecimal shares, OffsetDateTime awardedAt,
		BigDecimal pricePerShare, String externalEventId, String metadataJson) {
}
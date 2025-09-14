package com.stockmarket.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record PriceDto(String symbol, BigDecimal pricePerShare, String source, OffsetDateTime fetchedAt) {
}
package com.stockmarket.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class HoldingKey implements Serializable {
	private UUID userId;
	private String symbol;

	public HoldingKey(UUID userId, String symbol) {
		this.userId = userId;
		this.symbol = symbol;
	}

	public HoldingKey() {
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, symbol);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		HoldingKey that = (HoldingKey) o;
		return Objects.equals(userId, that.userId) && Objects.equals(symbol, that.symbol);
	}

}

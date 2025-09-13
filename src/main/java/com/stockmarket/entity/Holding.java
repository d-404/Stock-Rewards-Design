package com.stockmarket.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "holdings")
public class Holding {
	@EmbeddedId
	private HoldingKey id;

	@Column(nullable = false)
	private String symbol;

	@Column(precision = 18, scale = 6, nullable = false)
	private BigDecimal shares = BigDecimal.ZERO;

	@Column(precision = 18, scale = 4, nullable = false)
	private BigDecimal avgCostInr;

	@Column(nullable = false)
	private OffsetDateTime updatedAt;

	public Holding() {
	}

	public Holding(HoldingKey id, String symbol, BigDecimal shares, BigDecimal avgCostInr, OffsetDateTime updatedAt) {
		this.id = id;
		this.symbol = symbol;
		this.shares = shares;
		this.avgCostInr = avgCostInr;
		this.updatedAt = updatedAt;
	}

	public HoldingKey getId() {
		return id;
	}

	public void setId(HoldingKey id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public BigDecimal getShares() {
		return shares;
	}

	public void setShares(BigDecimal shares) {
		this.shares = shares;
	}

	public BigDecimal getAvgCostInr() {
		return avgCostInr;
	}

	public void setAvgCostInr(BigDecimal avgCostInr) {
		this.avgCostInr = avgCostInr;
	}

	public OffsetDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(OffsetDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}

package com.stockmarket.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name = "rewards", indexes = { @Index(columnList = "externalEventId", unique = true) })
public class Reward {
	@Id
	@GeneratedValue
	private UUID id;

	@Column(nullable = false)
	private UUID userId;

	@Column(precision = 18, scale = 6, nullable = false)
	private BigDecimal shares;

	@Column(nullable = false)
	private String symbol;

	@Column(nullable = false)
	private OffsetDateTime awardedAt;

	@Column(precision = 18, scale = 4, nullable = false)
	private BigDecimal totalInr;

	@Column(precision = 18, scale = 4, nullable = false)
	private BigDecimal pricePerShare;

	@Column(unique = true)
	private String externalEventId;

	@Column(columnDefinition = "jsonb")
	private String metadata;

	@Column(nullable = false)
	private OffsetDateTime createdAt = OffsetDateTime.now();

	public Reward() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public BigDecimal getShares() {
		return shares;
	}

	public void setShares(BigDecimal shares) {
		this.shares = shares;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public OffsetDateTime getAwardedAt() {
		return awardedAt;
	}

	public void setAwardedAt(OffsetDateTime awardedAt) {
		this.awardedAt = awardedAt;
	}

	public BigDecimal getTotalInr() {
		return totalInr;
	}

	public void setTotalInr(BigDecimal totalInr) {
		this.totalInr = totalInr;
	}

	public BigDecimal getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(BigDecimal pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public String getExternalEventId() {
		return externalEventId;
	}

	public void setExternalEventId(String externalEventId) {
		this.externalEventId = externalEventId;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}

}

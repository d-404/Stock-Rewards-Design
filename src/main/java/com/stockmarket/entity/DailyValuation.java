package com.stockmarket.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "daily_valuations")
public class DailyValuation {
	@Id
	@GeneratedValue
	private UUID id;

	@Column(nullable = false)
	private UUID userId;

	@Column(nullable = false)
	private LocalDate date;

	@Column(precision = 18, scale = 4, nullable = false)
	private BigDecimal totalInr;

	@Column(columnDefinition = "jsonb", nullable = false)
	private String bySymbol;

	@Column(nullable = false)
	private OffsetDateTime createdAt = OffsetDateTime.now();

	public DailyValuation() {
	}

	public DailyValuation(UUID id, UUID userId, LocalDate date, BigDecimal totalInr, String bySymbol,
			OffsetDateTime createdAt) {
		this.id = id;
		this.userId = userId;
		this.date = date;
		this.totalInr = totalInr;
		this.bySymbol = bySymbol;
		this.createdAt = createdAt;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public BigDecimal getTotalInr() {
		return totalInr;
	}

	public void setTotalInr(BigDecimal totalInr) {
		this.totalInr = totalInr;
	}

	public String getBySymbol() {
		return bySymbol;
	}

	public void setBySymbol(String bySymbol) {
		this.bySymbol = bySymbol;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}

}

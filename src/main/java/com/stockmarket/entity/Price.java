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
@Table(name = "prices", indexes = { @Index(columnList = "symbol") })
public class Price {
	@Id
	@GeneratedValue
	private UUID id;

	@Column(nullable = false)
	private String symbol;

	@Column(precision = 18, scale = 4, nullable = false)
	private BigDecimal pricePerShare;

	@Column(nullable = false)
	private String source;

	@Column(nullable = false)
	private OffsetDateTime fetchedAt = OffsetDateTime.now();

	public Price() {
	}

	public Price(UUID id, String symbol, BigDecimal pricePerShare, String source, OffsetDateTime fetchedAt) {
		super();
		this.id = id;
		this.symbol = symbol;
		this.pricePerShare = pricePerShare;
		this.source = source;
		this.fetchedAt = fetchedAt;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public BigDecimal getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(BigDecimal pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public OffsetDateTime getFetchedAt() {
		return fetchedAt;
	}

	public void setFetchedAt(OffsetDateTime fetchedAt) {
		this.fetchedAt = fetchedAt;
	}

}

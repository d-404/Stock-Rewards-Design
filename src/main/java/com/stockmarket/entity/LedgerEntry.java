package com.stockmarket.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ledger_entries")
public class LedgerEntry {
	@Id
	@GeneratedValue
	private UUID id;

	@Column(nullable = false)
	private UUID userId;

	@Column(nullable = false)
	private String account;

	@Column(precision = 18, scale = 4, nullable = false)
	private BigDecimal amountInr;

	@Column(nullable = false)
	private String type;

	@Column(nullable = false)
	private String referenceId;

	@Column(nullable = false)
	private OffsetDateTime createdAt = OffsetDateTime.now();

	public LedgerEntry() {
	}

	public LedgerEntry(UUID id, UUID userId, String account, BigDecimal amountInr, String type, String referenceId,
			OffsetDateTime createdAt) {
		this.id = id;
		this.userId = userId;
		this.account = account;
		this.amountInr = amountInr;
		this.type = type;
		this.referenceId = referenceId;
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public BigDecimal getAmountInr() {
		return amountInr;
	}

	public void setAmountInr(BigDecimal amountInr) {
		this.amountInr = amountInr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}

}

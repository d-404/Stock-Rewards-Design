package com.stockmarket.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmarket.dto.LedgerEntryDto;
import com.stockmarket.entity.LedgerEntry;
import com.stockmarket.entity.Reward;
import com.stockmarket.repository.LedgerEntryRepository;

@Service
public class LedgerService {
	private final LedgerEntryRepository ledgerEntryRepository;

	public LedgerService(LedgerEntryRepository ledgerEntryRepository) {
		this.ledgerEntryRepository = ledgerEntryRepository;
	}

	@Transactional
	public void recordRewardEntry(Reward reward) {
		LedgerEntry entry = new LedgerEntry(reward.getUserId(), "stock:" + reward.getSymbol(), reward.getTotalInr(),
				"CREDIT", reward.getId().toString());
		entry.setCreatedAt(OffsetDateTime.now());
		ledgerEntryRepository.save(entry);
	}

	public LedgerEntryDto toLedgerEntry(LedgerEntry entry) {
		return new LedgerEntryDto(entry.getUserId(), entry.getAccount(), entry.getAmountInr(), entry.getType(),
				entry.getReferenceId(), entry.getCreatedAt());
	}

}

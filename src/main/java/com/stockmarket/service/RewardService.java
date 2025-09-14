package com.stockmarket.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmarket.dto.RewardRequest;
import com.stockmarket.dto.RewardResponse;
import com.stockmarket.entity.Reward;
import com.stockmarket.repository.RewardRepository;

@Service
public class RewardService {
	private final RewardRepository rewardRepository;
	private final HoldingService holdingService;
	private final LedgerService ledgerService;

	public RewardService(RewardRepository rewardRepository, HoldingService holdingService,
			LedgerService ledgerService) {
		this.rewardRepository = rewardRepository;
		this.holdingService = holdingService;
		this.ledgerService = ledgerService;
	}

	@Transactional
	public RewardResponse createReward(RewardRequest req) {
		Reward reward = new Reward();
		reward.setUserId(req.userId());
		reward.setSymbol(req.symbol());
		reward.setShares(req.shares());
		reward.setAwardedAt(req.awardedAt());
		reward.setPricePerShare(req.pricePerShare());
		reward.setTotalInr(req.shares().multiply(req.pricePerShare()));
		reward.setExternalEventId(req.externalEventId());
		reward.setMetadata(req.metadataJson());
		Reward saved = rewardRepository.save(reward);
		holdingService.addOrUpdateHolding(saved);
		ledgerService.recordRewardEntry(saved);
		return new RewardResponse(saved.getId(), "SUCCESS");
	}
}

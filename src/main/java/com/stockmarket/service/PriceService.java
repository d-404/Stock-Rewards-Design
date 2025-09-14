package com.stockmarket.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stockmarket.dto.PriceDto;
import com.stockmarket.entity.Price;
import com.stockmarket.repository.PriceRepository;

@Service
public class PriceService {
	private final PriceRepository priceRepository;

	public PriceService(PriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}

	public PriceDto getLatestPrice(String symbol) {
		Optional<Price> priceOptional = priceRepository.findFirstBySymbolOrderByFetchedAtDesc(symbol);
		return priceOptional
				.map(p -> new PriceDto(p.getSymbol(), p.getPricePerShare(), p.getSource(), p.getFetchedAt()))
				.orElse(null);
	}

	public Price savePice(Price price) {
		return priceRepository.save(price);
	}
}

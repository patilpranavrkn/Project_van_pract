package com.example.h2.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.h2.entity.TradeStore;
@Component
public interface TradeOperationsService {

	public List<TradeStore> findAll();


	public void updateExpiryFlagOfTrade();

	public TradeStore saveNewTrade(TradeStore newTradeDate);

	public void validateTrade(TradeStore newTradeDate);


}

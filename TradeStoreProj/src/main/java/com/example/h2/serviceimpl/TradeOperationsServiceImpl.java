package com.example.h2.serviceimpl;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.h2.entity.TradeStore;
import com.example.h2.exception.TradeOperationsCustomException;
import com.example.h2.repository.TradeStoreRepository;
import com.example.h2.service.TradeOperationsService;
@Service
public class TradeOperationsServiceImpl  implements TradeOperationsService{
	
	private static final Logger log = LoggerFactory.getLogger(TradeOperationsServiceImpl.class);

	@Autowired
	TradeStoreRepository tradeStoreRepository;

	public List<TradeStore> findAll() {
		return tradeStoreRepository.findAll();
	}


	private boolean validateMaturityOfDates(TradeStore newTradeDate) {
		return newTradeDate.getMaturityDate().isBefore(LocalDate.now()) ? false : true;
	}

	public void validateTrade(TradeStore newTradeDate) {
		if (!validateMaturityOfDates(newTradeDate)) {
			log.info("Cannot Proceed with the Trade as Maturity Date is less than today Date for Trade ID :"
					+ newTradeDate.getTradeId());
			throw new TradeOperationsCustomException(
					"Cannot Proceed with the Trade as Maturity Date is less than today Date for Trade ID :"
							+ newTradeDate.getTradeId());
		}
		int count = tradeStoreRepository.getcount(newTradeDate.getTradeId(), newTradeDate.getVersion());
		if (count > 0) {
			log.info("Invalid Version of Trade Recieved for trade with ID:" + newTradeDate.getTradeId());
			throw new TradeOperationsCustomException(
					"Invalid Version of Trade Recieved for trade with ID:" + newTradeDate.getTradeId());
		}
	}

	public void updateExpiryFlagOfTrade() {
		log.info("Updating Expiry Flags of Trades based on Maturity Date");
		tradeStoreRepository.updateExpiryFlagBasedOnMaturity();
	}

	public TradeStore saveNewTrade(TradeStore newTradeDate) {
		newTradeDate.setCreatedDate(LocalDate.now());					//Setting created date to today's Date Explicitly
		return tradeStoreRepository.save(newTradeDate);
	}
    

}

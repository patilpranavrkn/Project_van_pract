
package com.example.h2.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TradeScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(TradeScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	TradeOperationsService tradeOperationService;
	@Scheduled(cron = "${trade.expiry.schedule}")//currentlly setup 30 seconds
	public void reportCurrentTime() {
		log.info("Updating Flags at Time", dateFormat.format(new Date()));
		tradeOperationService.updateExpiryFlagOfTrade();
	}
}
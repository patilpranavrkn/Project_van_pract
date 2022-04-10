package com.example.h2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2.constant.StoreConstants;
import com.example.h2.entity.TradeStore;
import com.example.h2.exception.TradeOperationsCustomException;
import com.example.h2.model.BaseApiResponse;
import com.example.h2.model.ResponseListResponse;
import com.example.h2.service.TradeOperationsService;

@RestController
public class TradeStoreController {
	
	@Autowired
	TradeOperationsService tradeOperationService;
	
	@GetMapping("/trades")
	public ResponseEntity<ResponseListResponse> getAllProduct(){
		ResponseListResponse response =new ResponseListResponse();
		List<TradeStore>  data=tradeOperationService.findAll();
		response.setError(false);
		response.setStatusCode(StoreConstants.HTTP_OK_STATUS_CODE);
		response.setStatusMessage(StoreConstants.VALID_MESSAGE);
		response.setData(data);
		return ResponseEntity.ok().body(response);
	}
	
	
	@PostMapping("/createtrade")
	public ResponseEntity<BaseApiResponse> createTrade( @Valid @RequestBody TradeStore newTradeStore){
		
		BaseApiResponse response =new BaseApiResponse();
		try {
			tradeOperationService.validateTrade(newTradeStore);
		} catch (TradeOperationsCustomException exp) {
			response.setError(true);
			response.setStatusCode(StoreConstants.HTTP_FORBIDDEN_STATUS_CODE);
			response.setStatusMessage(exp.getMessage());
			return ResponseEntity.status(403).body(response);
		}
		tradeOperationService.saveNewTrade(newTradeStore);
		response.setError(false);
		response.setStatusCode(StoreConstants.HTTP_OK_STATUS_CODE);
		response.setStatusMessage(StoreConstants.SUCCESS_TRADE_RECORD);
		return ResponseEntity.ok().body(response);
	}
	

}

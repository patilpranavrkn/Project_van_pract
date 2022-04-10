package com.example.h2.model;

import java.util.List;

import com.example.h2.entity.TradeStore;

public class ResponseListResponse extends BaseApiResponse {
	
	 public List<TradeStore> getData() {
		return data;
	}

	public void setData(List<TradeStore> data) {
		this.data = data;
	}

	List<TradeStore> data;

}

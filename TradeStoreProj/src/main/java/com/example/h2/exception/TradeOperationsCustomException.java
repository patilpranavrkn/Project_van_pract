package com.example.h2.exception;

public class TradeOperationsCustomException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  TradeOperationsCustomException(String message)
	{
		super(message);
	}
}

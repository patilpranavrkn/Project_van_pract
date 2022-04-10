package com.example.h2.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CreateRecordSaveRequest {
	
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getCounterPartyId() {
		return counterPartyId;
	}
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDate getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}

	@NotBlank
	@NotEmpty
	@NotNull
	private String tradeId;
	@Column(name="VERSION")
	@NotNull
	private Integer version;
	@NotNull
	@NotEmpty
	private String counterPartyId;
	@NotNull
	@NotEmpty
	@NotBlank
	private String bookingId;
	@NotNull
	@NotEmpty
	@Pattern(regexp="YYYY-MM-DD",message="Date should be in YYYY-MM-DD only")
	private LocalDate maturityDate;
	@Pattern(regexp="^(?:Y|N)$",message="expired flag can be Y or N only")
	@NotNull
	@NotEmpty
	@NotBlank
	private String expired;

}

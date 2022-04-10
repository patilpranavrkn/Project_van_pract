package com.example.h2.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="TRADESTORE")
public class TradeStore {
	
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
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
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
	@Id
	@NotBlank(message="TradeId cant be blank")
	@NotEmpty(message=" TradeId cant be empty")
	@NotNull(message=" TradeId cant be null")
	@Size(max=255)																			// the maximum size of tradeId can be 255 characters as h2 db has String of size 255 Chars
	private String tradeId;
	@NotNull(message="version cant be null")
	private Integer version;
	@NotBlank(message="counterPartyId cant be blank")
	@NotEmpty(message="counterPartyId cant be empty")
	@NotNull(message="counterPartyId cant be null")
	@Size(max=255)
	private String counterPartyId;
	@NotBlank(message="bookingId cant be blank")
	@NotEmpty(message="bookingId cant be empty")
	@NotNull(message="bookingId cant be null")
	@Size(max=255)
	private String bookingId;
	private LocalDate createdDate;
	private LocalDate maturityDate;
	@NotBlank(message="Expired cant be blank")
	@NotEmpty(message="Expired cant be blank")
	@NotNull(message=" Expired cant be null")
	@Size(max=1,min=1)
	@Pattern(regexp="^(?:Y|N)$",message="expired flag can be Y or N only")					// assumming expiry flag of trade can be Y or N only and adding this validation
	private String expired;

}

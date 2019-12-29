package com.mircrServ.currencyexchangeservice.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CurrExchangeVal {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	@Column(name="curr_from")
	private String from;
	
	@Column(name="curr_to")
	private String to;
	private BigDecimal conversionVal;
	private int port;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionVal() {
		return conversionVal;
	}
	public void setConversionVal(BigDecimal conversionVal) {
		this.conversionVal = conversionVal;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	public CurrExchangeVal(Long id, String from, String to, BigDecimal conversionVal) {
		super();
		Id = id;
		this.from = from;
		this.to = to;
		this.conversionVal = conversionVal;
	}
	
	public CurrExchangeVal() {
		
	}
	
	
}

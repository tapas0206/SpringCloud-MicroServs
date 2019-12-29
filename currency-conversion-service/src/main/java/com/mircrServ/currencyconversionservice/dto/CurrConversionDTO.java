package com.mircrServ.currencyconversionservice.dto;

import java.math.BigDecimal;

public class CurrConversionDTO {

	private Long Id;
	private String to;
	private String from;
	private BigDecimal quanitiy;
	private BigDecimal tot_calculated_amt;
	private int port;
	private BigDecimal conversionVal;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public BigDecimal getQuanitiy() {
		return quanitiy;
	}
	public void setQuanitiy(BigDecimal quanitiy) {
		this.quanitiy = quanitiy;
	}
	public BigDecimal getTot_calculated_amt() {
		return tot_calculated_amt;
	}
	public void setTot_calculated_amt(BigDecimal tot_calculated_amt) {
		this.tot_calculated_amt = tot_calculated_amt;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public BigDecimal getConversionVal() {
		return conversionVal;
	}
	public void setConversionVal(BigDecimal conversionVal) {
		this.conversionVal = conversionVal;
	}
	
	public CurrConversionDTO(Long id, String to, String from, BigDecimal quanitiy, BigDecimal tot_calculated_amt,
			int port, BigDecimal conversionVal) {
		super();
		Id = id;
		this.to = to;
		this.from = from;
		this.quanitiy = quanitiy;
		this.tot_calculated_amt = tot_calculated_amt;
		this.port = port;
		this.conversionVal = conversionVal;
	}
	
	public CurrConversionDTO() {

	}
	@Override
	public String toString() {
		return "CurrConversionDTO [Id=" + Id + ", to=" + to + ", from=" + from + ", quanitiy=" + quanitiy
				+ ", tot_calculated_amt=" + tot_calculated_amt + ", port=" + port + ", conversionVal=" + conversionVal
				+ "]";
	}
	
	

}

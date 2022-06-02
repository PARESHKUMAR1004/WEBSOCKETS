package com.server.restmysql.model;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
public class TradeInfo {
	@Id
	@Column(name = "time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private java.sql.Timestamp time;
	
	@Column(name = "volume")
	private Integer volume;
	@Column(name = "price")
	private double price;
	@Column(name = "symbol")
	private String symbol;
	
	TradeInfo(){
		
	}
	
	public TradeInfo(Timestamp time, Integer volume, double price, String symbol) {
		super();
		this.time = time;
		this.volume = volume;
		this.price = price;
		this.symbol = symbol;
	}

	public java.sql.Timestamp getTime() {
		return time;
	}
	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	

}

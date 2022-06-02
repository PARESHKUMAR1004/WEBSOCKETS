package com.server.restmysql.model;



import lombok.*;

import java.util.Date;


public class Message {
   
	private String trade_id;
    private String receiverName;
    private String status;
    private java.sql.Timestamp timestamp;
    private int volume;
    private double price;
    private String side;
    private String symbol;
    
    
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String trade_id, String receiverName, String status,java.sql.Timestamp timestamp, int volume, double price,
			String side,String symbol) {
		super();
		this.trade_id = trade_id;
		this.receiverName = receiverName;
		this.status = status;
		this.timestamp = timestamp;
		this.volume = volume;
		this.price = price;
		this.side = side;
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getTrade_id() {
		return trade_id;
	}
	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public java.sql.Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(java.sql.Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
    
    
    
	
    
    
	
}

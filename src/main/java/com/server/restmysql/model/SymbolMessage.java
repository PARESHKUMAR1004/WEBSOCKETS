package com.server.restmysql.model;

public class SymbolMessage {

	
	String username;
	String symbol;
	
	public SymbolMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SymbolMessage(String username, String symbol) {
		super();
		this.username = username;
		this.symbol = symbol;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	
}

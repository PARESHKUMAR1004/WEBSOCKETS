package com.server.restmysql.model;
//
//import java.sql.Timestamp;
//import java.util.UUID;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
////import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
//@Entity
//public class Trades {
//
//	
//	
//	
//	
//	@Id
//	@Column(name = "trade_id")
//	private String tradeId;
//	
//	
//	@Column(name = "timestamp")
//	private Long  timestamp;
//
//	@Column(name = "buyer_id")
//	private Integer buyerId;
//
//	@Column(name = "seller_id")
//	private Integer sellerId;
//
//	
//	@Column(name = "volume")
//	private Integer volume;
//	@Column(name = "price")
//	private double price;
//	@Column(name = "symbol")
//	private String symbol;
//
//	public Trades() {
//
//	}
//
//	public Trades(String tradeId, Long timestamp, Integer buyerId, Integer sellerId, Integer volume, double price,
//			String symbol) {
//		super();
//		this.tradeId = tradeId;
//		this.timestamp = timestamp;
//		this.buyerId = buyerId;
//		this.sellerId = sellerId;
//		this.volume = volume;
//		this.price = price;
//		this.symbol = symbol;
//	}
//
//	public String getTradeId() {
//		return tradeId;
//	}
//
//	public void setTradeId(String tradeId) {
//		this.tradeId = tradeId;
//	}
//
//	public Long getTimestamp() {
//		return timestamp;
//	}
//
//	public void setTimestamp(Long timestamp) {
//		this.timestamp = timestamp;
//	}
//
//	public Integer getBuyerId() {
//		return buyerId;
//	}
//
//	public void setBuyerId(Integer buyerId) {
//		this.buyerId = buyerId;
//	}
//
//	public Integer getSellerId() {
//		return sellerId;
//	}
//
//	public void setSellerId(Integer sellerId) {
//		this.sellerId = sellerId;
//	}
//
//	public Integer getVolume() {
//		return volume;
//	}
//
//	public void setVolume(Integer volume) {
//		this.volume = volume;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//
//	public String getSymbol() {
//		return symbol;
//	}
//
//	public void setSymbol(String symbol) {
//		this.symbol = symbol;
//	}
//	
//
//	
//}


//package com.example.tmserver.Model;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Trades {


    @Id
    @Column(name = "trade_id")
    private String trade_id;

    @Column(name = "timestamp", columnDefinition = "TIMESTAMP")
    private java.sql.Timestamp timestamp;

    @Column(name = "buyer_id")
    private Integer buyer_id;

    @Column(name = "seller_id")
    private Integer seller_id;

//    @Column(name = "buyer_order_id")
//    private Integer buyer_order_id;
//
//    @Column(name = "seller_order_id")
//    private Integer seller_order_id;

    @Column(name = "volume")
    private Integer volume;
    @Column(name = "price")
    private double price;
    @Column(name = "symbol")
    private String symbol;

    public Trades() {
    	super();
    }
    
    @Autowired
    public Trades(String t_id, int bId, int sId, double price, int vol, long time, String symbol) {
    	super();
    	System.out.println(time);
    	this.trade_id = t_id;
    	this.buyer_id = bId;
    	this.seller_id = sId;
    	this.price = price;
    	this.volume = vol;
    	System.out.println(time);
    	this.timestamp = Timestamp.from(new Date(time).toInstant());
    	System.out.println(this.timestamp);
    	this.symbol = symbol;
    	
    	
    }

    public String getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(String trade_id) {
        this.trade_id = trade_id;
    }

    public java.sql.Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long time) {
    	System.out.println(time);
        this.timestamp = Timestamp.from(new Date(time).toInstant());
        System.out.println(this.timestamp);
    }

    public Integer getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(Integer buyer_id) {
        this.buyer_id = buyer_id;
    }

    public Integer getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Integer seller_id) {
        this.seller_id = seller_id;
    }

//    public Integer getBuyer_order_id() {
//        return buyer_order_id;
//    }
//
//    public void setBuyer_order_id(Integer buyer_order_id) {
//        this.buyer_order_id = buyer_order_id;
//    }
//
//    public Integer getSeller_order_id() {
//        return seller_order_id;
//    }
//
//    public void setSeller_order_id(Integer seller_order_id) {
//        this.seller_order_id = seller_order_id;
//    }

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

    @Override
	public String toString() {
		return "Trades [trade_id=" + trade_id + ", timestamp=" + timestamp + ", buyer_id=" + buyer_id + ", seller_id=" + seller_id
				+ ", volume=" + volume + ", price=" + price + ", symbol=" + symbol + "]";
	}

	public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}

package com.server.restmysql.repository;

import com.server.restmysql.model.Trades;
import com.server.restmysql.model.TradeInfo;

import java.util.List;

//import antlr.collections.List;
//package com.server.restmysql.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TradesRepository extends JpaRepository<Trades, Integer> {
	@Query(value = "SELECT * FROM Trades t", 
			  nativeQuery = true)
			List<Trades> showDetails();
	
	
	
	
	
	@Query(value = "SELECT * FROM Trades t WHERE t.buyer_id = :buyer_id", 
			  nativeQuery = true)
			List<Trades> findTradeByBuyer_idNative(
			  @Param("buyer_id") Integer price);
	
	
	@Query(value = "SELECT * FROM Trades t WHERE t.price > :price", 
			  nativeQuery = true)
			List<Trades> findTradeGreaterThanPrice(
			  @Param("price") Integer price);
	
	 @Query(value="select t.time , t.price ,t.volume ,t.symbol from Trades t",nativeQuery=true)
	    List<Object> getInfo(); 
	 
	 
	/* @Modifying
	 @Query(
	   value = 
	     "insert into Trades (buyer_id, seller_id,buyer_order_id,seller_order_id,volume,price,symbol) values (:buyer_id, :seller_id, :buyer_order_id, :seller_order_id,:volume,:price,:symbol)",
	   nativeQuery = true)
	 void insertTrade(@Param("buyer_id") Integer buyer_id, @Param("seller_id") Integer seller_id, @Param("buyer_order_id") Integer buyer_order_id,
			 @Param("seller_order_id") Integer seller_order_id,
	   @Param("volume") Integer volume,@Param("price") Integer price, @Param("symbol") String symbol);
	   
	   */
	
	
}


//package com.example.tmserver.Repository;
//
//import com.example.tmserver.Model.Trades;

//import java.util.List;
//
////import antlr.collections.List;
////package com.server.restmysql.resource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//@Repository
//public interface TradesRepository extends JpaRepository<Trades, Integer> {
//    @Query(value = "SELECT * FROM Trades t",
//            nativeQuery = true)
//    List<Trades> showDetails();
//
//    @Query(value = "SELECT * FROM Trades t WHERE t.buyer_id = :buyer_id",
//            nativeQuery = true)
//    List<Trades> findTradeByBuyer_idNative(
//            @Param("buyer_id") Integer price);
//
//
//    @Query(value = "SELECT * FROM Trades t WHERE t.price > :price",
//            nativeQuery = true)
//    List<Trades> findTradeGreaterThanPrice(
//            @Param("price") Integer price);
//
//    @Query(value="select t.time , t.price ,t.volume ,t.symbol from Trades t",nativeQuery=true)
//    List<Object> getInfo();
//
//
//	/* @Modifying
//	 @Query(
//	   value =
//	     "insert into Trades (buyer_id, seller_id,buyer_order_id,seller_order_id,volume,price,symbol) values (:buyer_id, :seller_id, :buyer_order_id, :seller_order_id,:volume,:price,:symbol)",
//	   nativeQuery = true)
//	 void insertTrade(@Param("buyer_id") Integer buyer_id, @Param("seller_id") Integer seller_id, @Param("buyer_order_id") Integer buyer_order_id,
//			 @Param("seller_order_id") Integer seller_order_id,
//	   @Param("volume") Integer volume,@Param("price") Integer price, @Param("symbol") String symbol);
//
//	   */
//
//
//}

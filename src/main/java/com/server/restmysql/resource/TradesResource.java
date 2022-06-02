package com.server.restmysql.resource;


import org.json.simple.JSONObject;
import com.server.restmysql.model.Trades;
import com.server.restmysql.model.Message;
import com.server.restmysql.model.TradeInfo;

import com.server.restmysql.repository.TradesRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/trades")
public class TradesResource {

    @Autowired
    TradesRepository tradesRepository;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /*@GetMapping("/all")
    public List<Trades> getAll() {
        return tradesRepository.findAll();
    }*/
    @GetMapping("/all")
    public List<Trades> getAll() {
        return tradesRepository.findAll();
    }
    
    
    /*@GetMapping("/info")
    public List<Object> showInfo() {
       List<Object>a= tradesRepository.getInfo();
       List<TradeInfo>res;
       for(Object b:a)
       {
    	   System.out.println(b.toString());
    	 //TradeInfo t(b[0],b[1],b[2],b[3]);  
       }
       return a;
    }*/

    @PostMapping(value = "/load")
    public List<Trades> persist(@RequestBody final Trades trade) {
    	System.out.println(trade.toString());
    	
    	
    	//Trades trade2=new Trades("3lcgg35b-0000-9dof-sr99-803fc048rt0c",1000,2000,234.23,90,45433453,"GOOGLE");
        tradesRepository.save(trade);
        
        Message buyerMessage=new Message(trade.getTrade_id(),trade.getBuyer_id().toString(),"COMPLETED",trade.getTimestamp(),trade.getVolume(),trade.getPrice(),"BUY",trade.getSymbol());
        Message sellerMessage=new Message(trade.getTrade_id(),trade.getSeller_id().toString(),"COMPLETED",trade.getTimestamp(),trade.getVolume(),trade.getPrice(),"SELL",trade.getSymbol());
        simpMessagingTemplate.convertAndSendToUser(buyerMessage.getReceiverName(),"/private",buyerMessage);
        simpMessagingTemplate.convertAndSendToUser(sellerMessage.getReceiverName(),"/private",sellerMessage);
        
        return tradesRepository.findAll();
       // return trade;
    }
    
    @PostMapping(value = "/loadJsonToSpecificUser")
    public void loadJsonToUser(@RequestBody final JSONObject obj )
    {
    	
    	simpMessagingTemplate.convertAndSendToUser(obj.get("buyerId").toString(),"/private",obj);
    	simpMessagingTemplate.convertAndSendToUser(obj.get("sellerId").toString(),"/private",obj);
    	
    }
    @PostMapping(value = "/orderbookbySymbol")
    public void sendOrderBookToAllUSer(@RequestBody final JSONObject obj )
    {
    	System.out.println("Hitted symbol");
    	simpMessagingTemplate.convertAndSendToUser(obj.get("symbol").toString(),"/symbol",obj);
    	//simpMessagingTemplate.convertAndSendToUser(obj.get("sellerId").toString(),"/private",obj);
    	
    }
    
    
    
    
    @GetMapping("/find/{buyer_id}")
    public List<Trades> getDetails(@PathVariable("buyer_id") final Integer buyer_id) {

        

        return tradesRepository.findTradeByBuyer_idNative(buyer_id);
    }

    @GetMapping("/findprice/{price}")
    public List<Trades> getPriceDetails(@PathVariable("price") final Integer price) {

        

        return tradesRepository.findTradeGreaterThanPrice(price);
    }

}

package com.server.restmysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.server.restmysql.model.SymbolMessage;



@Controller
public class orderBookController {
	
	@Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

//	 @MessageMapping("/symbol")
//	 public void sendOrderBook(@Payload SymbolMessage symbolmessage){
//		 System.out.println("Hittted");
//	        simpMessagingTemplate.convertAndSendToUser(symbolmessage.getUsername(),"/symbol","Dear User with user id "+symbolmessage.getUsername()+". Your order book for "+symbolmessage.getSymbol()+" is here ");
//	       
//	    }

}

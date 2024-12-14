package de.smarthome.smartux.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import de.smarthome.smartux.mainDataModel.StompMessage;

@Controller
public class MessageController {
    
    @MessageMapping("/sendMessage")
    @SendTo("/topic/public")
    public StompMessage sendMessage(@Payload StompMessage chatMessage) {
        
        return chatMessage;
        
    }

    @MessageMapping("/addUser")
    @SendTo("/topic/public")
    public StompMessage addUser(@Payload StompMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getType());
        return chatMessage;
        
    }
}


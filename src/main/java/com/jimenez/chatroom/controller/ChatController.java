package com.jimenez.chatroom.controller;

import com.jimenez.chatroom.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

// @Controller indicates that this class is a Spring MVC controller that handles WebSocket messages.
@Controller
public class ChatController {

    // @MessageMapping maps incoming messages to the /app/chat destination to this method.
    // @SendTo broadcasts the return value to all subscribers of the /topic/messages destination.
    // The method takes a ChatMessage object as input and returns it, effectively echoing the message to all connected
    // clients.
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage send(ChatMessage message) { // - Need to implement ChatMessage class in model package
        return message;
    }
}

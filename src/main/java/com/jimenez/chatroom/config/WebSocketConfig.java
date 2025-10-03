package com.jimenez.chatroom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocket configuration for enabling STOMP-based messaging in the chat application.
 * - @Configuration tells Spring this is a configuration class.
 * - @EnableWebSocketMessageBroker activates WebSocket message handling with a message broker.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Method configures the message broker, which is responsible for routing messages from one client to another.
     * - enableSimpleBroker("/topic") creates an in-memory broker for broadcasting messages
     *   to all subscribers who listen on destinations with the "/topic" prefix.
     * - setApplicationDestinationPrefixes("/app") means client messages with this prefix
     *   will be routed to @MessageMapping methods in controller classes.
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * Register STOMP (Simple Test Oriented Messaging Protocol) endpoints that clients will
     * use to connect to the WebSocket server.
     * - "/ws" is the endpoint that clients will use to establish a WebSocket connection.
     * - withSockJS() enables SockJS fallback options for browsers that don't support native WebSocket.
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }
}

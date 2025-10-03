package com.jimenez.chatroom.model;

public class ChatMessage {

    // Fields for message content and sender's username
    private String content;
    private String username;

    // Getters and setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
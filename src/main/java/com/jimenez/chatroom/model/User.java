package com.jimenez.chatroom.model;

public class User {
    private String username;
    private boolean online;

    // Constructor
    public User(String username) {
        this.username = username;
        this.online = true; // default to online when created
    }

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isOnline() {
        return online;
    }
    public void setOnline(boolean online) {
        this.online = online;
    }
}
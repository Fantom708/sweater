package com.example.sweater.domain.dto;

import com.example.sweater.domain.Message;
import com.example.sweater.domain.Role;
import com.example.sweater.domain.User;

import java.util.HashSet;
import java.util.Set;

public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private boolean active;
    private String activationCode;
    private Set<Role> roles;
    private Set<Message> messages;
    private Set<User> subscribers = new HashSet<>();
    private int posts;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.active = user.isActive();
        this.activationCode = user.getActivationCode();
        this.messages = user.getMessages();
        this.roles = user.getRoles();
        this.subscribers = user.getSubscribers();
        this.posts = user.getMessages().size();
    }

    public int getPosts() {
        return messages.size();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public Set<User> getSubscribers() {
        return subscribers;
    }
}

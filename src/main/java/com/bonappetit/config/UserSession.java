package com.bonappetit.config;

import com.bonappetit.model.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserSession {

    private long id;

    private String username;

    public void login(User user) {
        this.username = user.getUsername();
        this.id = user.getId();
    }

    public void logout() {
        this.username = null;
        this.id = 0;
    }

    public boolean isLoggedIn() {
        return this.id != 0;
    }

    public String getUsername() {
        return this.username;
    }
}

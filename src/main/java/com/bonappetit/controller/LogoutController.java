package com.bonappetit.controller;

import com.bonappetit.config.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    private final UserSession userSession;

    public LogoutController(UserSession userSession) {
        this.userSession = userSession;
    }

    @GetMapping("/logout")
    public String logout() {

        if (userSession.isLoggedIn()) {
            userSession.logout();

            return "redirect:/";
        }



        return "index";
    }
}

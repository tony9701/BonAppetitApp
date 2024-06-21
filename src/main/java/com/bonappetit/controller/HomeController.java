package com.bonappetit.controller;

import com.bonappetit.config.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final UserSession userSession;

    public HomeController(UserSession userSession) {
        this.userSession = userSession;
    }

    @GetMapping("/")
    public String loggedOut() {

        if (userSession.isLoggedIn()) {

            return "redirect:/home";
        }

        return "index";
    }


    @GetMapping("/home")
    public String loggedIn() {

        if (!userSession.isLoggedIn()) {
            return "redirect:/index";
        }

        return "home";
    }
}

package com.bonappetit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String indexView() {
        return "redirect:/";
    }
}

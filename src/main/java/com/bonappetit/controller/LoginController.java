package com.bonappetit.controller;

import com.bonappetit.config.UserSession;
import com.bonappetit.service.UserService;
import com.bonappetit.service.dtos.LoginUserDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    private final UserService userService;
    private final UserSession userSession;

    public LoginController(UserService userService, UserSession userSession) {
        this.userService = userService;
        this.userSession = userSession;
    }

    @ModelAttribute("loginData")
    public LoginUserDTO loginUserDTO() {
        return new LoginUserDTO();
    }

    @GetMapping("/login")
    public String loginView(Model model) {

        if (userSession.isLoggedIn()) {
            return "redirect:/home";
        }

        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@Valid LoginUserDTO loginUserDTO,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes)
    {

        if (bindingResult.hasErrors() || !userService.loginUser(loginUserDTO)) {
            redirectAttributes.addFlashAttribute("loginData", loginUserDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginData", bindingResult);

            return "redirect:/login";
        }


        return "redirect:/home";
    }



    //TODO: Fix login errors, Fix logout button, fix logout, make home controller, do the security
}

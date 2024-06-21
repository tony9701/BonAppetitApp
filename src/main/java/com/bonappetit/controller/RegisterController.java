package com.bonappetit.controller;

import com.bonappetit.config.UserSession;
import com.bonappetit.service.UserService;
import com.bonappetit.service.impl.UserServiceImpl;
import com.bonappetit.service.dtos.RegisterUserDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
public class RegisterController {


    private final UserService userService;
    private final UserSession userSession;

    public RegisterController(UserServiceImpl userServiceImpl, UserService userService, UserSession userSession) {

        this.userService = userService;
        this.userSession = userSession;
    }

    @ModelAttribute("registerData")
    public RegisterUserDTO registerUserDTO() {
        return new RegisterUserDTO();
    }

    @GetMapping("/register")
    public String registerView(Model model) {

        if (userSession.isLoggedIn()) {
            return "redirect:/home";
        }

        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid RegisterUserDTO registerData,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {



        if (bindingResult.hasErrors() || !userService.registerUser(registerData)) {
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.registerData", bindingResult);
            redirectAttributes.addFlashAttribute("registerData", registerData);

            return "redirect:/register";
        }


        return "redirect:/login";
    }
}

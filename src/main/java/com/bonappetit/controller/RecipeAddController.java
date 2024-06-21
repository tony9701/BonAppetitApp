package com.bonappetit.controller;

import com.bonappetit.model.entity.Recipe;
import com.bonappetit.service.dtos.RecipeDataDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RecipeAddController {

    @ModelAttribute("recipeData")
    public RecipeDataDTO recipeDataDTO() {
        return new RecipeDataDTO();
    }

    @GetMapping("recipe-add")
    public String addRecipeView(Model model) {

        return "recipe-add";
    }

    @PostMapping("recipe-add")
    public String addRecipe(@Valid RecipeDataDTO recipeDataDTO,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("recipeData", recipeDataDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.recipeData", bindingResult);

            return "redirect:/recipe-add";
        }

        //TODO recipe-add service and repo + methods, home page recipes loop

        return "/home";
    }
}

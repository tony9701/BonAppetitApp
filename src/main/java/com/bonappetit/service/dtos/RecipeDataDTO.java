package com.bonappetit.service.dtos;

import com.bonappetit.model.entity.enums.CategoriesEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RecipeDataDTO {

    @NotBlank
    @Size(min = 2, max = 40)
    private String name;

    @NotBlank
    @Size(min = 2, max = 40)
    private String ingredients;

    @NotBlank
    private String category;

    public @NotBlank String getCategory() {
        return category;
    }

    public void setCategory(@NotBlank String category) {
        this.category = category;
    }

    public @NotBlank String getIngredients() {
        return ingredients;
    }

    public void setIngredients(@NotBlank String ingredients) {
        this.ingredients = ingredients;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }
}

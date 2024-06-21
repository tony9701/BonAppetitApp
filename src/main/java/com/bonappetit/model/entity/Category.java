package com.bonappetit.model.entity;

import com.bonappetit.model.entity.BaseEntity.BaseEntity;
import com.bonappetit.model.entity.enums.CategoriesEnum;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private CategoriesEnum name;

    private String description;

    @OneToMany(mappedBy = "category")
    private Set<Recipe> recipes;

    public Category() {
        this.recipes = new HashSet<>();
    }

    public Category(CategoriesEnum categoriesName, String description) {
        this();
        this.name = categoriesName;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoriesEnum getName() {
        return name;
    }

    public void setName(CategoriesEnum name) {
        this.name = name;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}

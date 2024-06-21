package com.bonappetit.model.entity;

import com.bonappetit.model.entity.BaseEntity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "recipes")
public class Recipe extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 40)
    private String name;

    @Size(min = 2, max = 150)
    private String ingredients;

    @ManyToOne(optional = false)
    private Category category;

    @ManyToOne(optional = false)
    private User addedBy;

    public Recipe() {
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(getName(), recipe.getName()) && Objects.equals(getIngredients(), recipe.getIngredients()) && Objects.equals(getCategory(), recipe.getCategory()) && Objects.equals(getAddedBy(), recipe.getAddedBy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getIngredients(), getCategory(), getAddedBy());
    }
}

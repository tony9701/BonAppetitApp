package com.bonappetit.model.entity;

import com.bonappetit.model.entity.BaseEntity.BaseEntity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "addedBy")
    private Set<Recipe> addedRecipes;

    @ManyToMany()
    private Set<Recipe> favouriteRecipes;

    public User() {
        addedRecipes = new HashSet<>();
        favouriteRecipes = new HashSet<>();
    }

    public Set<Recipe> getAddedRecipes() {
        return addedRecipes;
    }

    public void setAddedRecipes(Set<Recipe> addedRecipes) {
        this.addedRecipes = addedRecipes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Recipe> getFavouriteRecipes() {
        return favouriteRecipes;
    }

    public void setFavouriteRecipes(Set<Recipe> favouriteRecipes) {
        this.favouriteRecipes = favouriteRecipes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

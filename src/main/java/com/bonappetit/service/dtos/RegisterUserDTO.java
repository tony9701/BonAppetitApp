package com.bonappetit.service.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterUserDTO {

    @Size(min = 3, max = 20)
    @NotBlank
    private String username;

    @Email
    @NotBlank
    private String email;

    @Size(min = 3, max = 20)
    @NotBlank
    private String password;

    @Size(min = 3, max = 20)
    @NotBlank
    private String confirmPassword;

    public RegisterUserDTO() {
    }

    public @Size(min = 3, max = 20) String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(@Size(min = 3, max = 20) @NotBlank String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @Size(min = 3, max = 20) String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 3, max = 20) String password) {
        this.password = password;
    }

    public @Size(min = 3, max = 20) String getUsername() {
        return username;
    }

    public void setUsername(@Size(min = 3, max = 20) String username) {
        this.username = username;
    }
}

package com.techelevator.model.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Login {
    @NotBlank(message = "Email is required")
    @Email(message = "Email format is incorrect")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

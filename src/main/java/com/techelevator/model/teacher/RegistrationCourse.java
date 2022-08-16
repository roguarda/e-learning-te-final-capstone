package com.techelevator.model;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;


public class RegistrationCourse {
    @NotBlank(message="Name is required")
    private String Name;
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }

    @NotBlank(message="Description is required")
    private String Description;
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        this.Description = description;
    }

    @NotBlank(message="Difficulty Level is required")
    private String DifficultyLevel;
    public String getDifficultyLevel() {
        return DifficultyLevel;
    }
    public void setDifficultyLevel(String difficultyLevel) {
        this.DifficultyLevel = difficultyLevel;
    }

    @NotBlank(message="Cost is required")
    private String Cost = "Free";
    public String getCost() {
        return Cost;
    }
    public void setCost(String cost) {this.Cost = cost;
    }


}
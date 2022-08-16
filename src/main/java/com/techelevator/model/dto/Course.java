package com.techelevator.model.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Course {

    private int courseid;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message="Description is required")
    private String description;

    @NotBlank(message="Difficulty Level is required")
    private String difficultyLevel;

    @NotBlank(message="Cost is required")
    private String cost;


    public int getId()
    {
        return courseid;
    }

    public void setId(int courseid)
    {
        this.courseid = courseid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription()
    {
        this.description = description;
    }

    public String getDifficultyLevel() { return difficultyLevel;}

    public void setDifficultyLevel(String difficultyLevel)
    {
        this.difficultyLevel = difficultyLevel;
    }

    public String getCost()
    {
        return cost;
    }

    public void setCost()
    {
        this.cost = cost;
    }
}

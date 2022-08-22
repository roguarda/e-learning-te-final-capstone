package com.techelevator.model.dto;

import org.hibernate.validator.constraints.NotBlank;

public class Course {

    private int id;

    private int teacherId;

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
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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

    public void setDescription(String description)
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

    public void setCost(String cost)
    {
        this.cost = cost;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }



}

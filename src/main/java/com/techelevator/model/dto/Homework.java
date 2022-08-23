package com.techelevator.model.dto;

import org.hibernate.validator.constraints.NotBlank;

public class Homework {

    private int id;
    String description;
    String status;

    @NotBlank(message = "Homework's name is required")
    private String homeworkName;

    @NotBlank(message="Homework's introduction is required")
    private String homeworkIntroduction;

    @NotBlank(message="Homework's Description is required")
    private String homeworkDescription;


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription()
    {
        this.description = description;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus()
    {
        this.status = status;
    }

    public String getHomeworkName() {
        return homeworkName;
    }

    public void setHomeworkName(String homeworkName)
    {
        this.homeworkName = homeworkName;
    }


    public String getHomeworkIntroduction() {
        return homeworkIntroduction;
    }

    public void setHomeworkIntroduction(String homeworkIntroduction) {
        this.homeworkIntroduction = homeworkIntroduction;
    }

    public String getHomeworkDescription() {
        return homeworkDescription;
    }

    public void setHomeworkDescription(String homeworkDescription) {
        this.homeworkDescription = homeworkDescription;
    }
}

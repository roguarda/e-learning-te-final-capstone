package com.techelevator.model.dto;

import org.hibernate.validator.constraints.NotBlank;

public class Curricula {

    private int id;

    @NotBlank(message = "Name is required")
    private String curriculaName;

    @NotBlank(message="Daily Instruction is required")
    private String dailyInstruction;

    @NotBlank(message="Daily Homework is required")
    private String dailyHomework;




    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getCurriculaName()
    {
        return curriculaName;
    }
    public void setCurriculaName(String curriculaName)
    {
        this.curriculaName = curriculaName;
    }

    public String getDailyInstruction()
    {
        return dailyInstruction;
    }
    public void setDailyInstruction(String dailyInstruction) {this.dailyInstruction = dailyInstruction;}

    public String getDailyHomework() { return dailyHomework;}
    public void setDailyHomework(String dailyHomework)
    {
        this.dailyHomework = dailyHomework;
    }


}

package com.techelevator.model.dto;

import org.hibernate.validator.constraints.NotBlank;

public class Curricula {

    private int curriculaid;

    @NotBlank(message = "Introduction is required")
    private String introduction;

    @NotBlank(message="Daily Instruction is required")
    private String dailyInstruction;

    @NotBlank(message="Daily Homework is required")
    private String dailyHomework;




    public int getId()
    {
        return curriculaid;
    }
    public void setId(int curriculaid)
    {
        this.curriculaid = curriculaid;
    }

    public String getIntroduction()
    {
        return introduction;
    }
    public void setIntroduction(String introduction)
    {
        this.introduction = introduction;
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
package com.techelevator.model.dto;

import org.hibernate.validator.constraints.NotBlank;

public class Curricula {

    private int curriculaId;

    @NotBlank(message = "Name is required")
    private String curriculaName;

    @NotBlank(message="Daily Instruction is required")
    private String dailyInstruction;

    @NotBlank(message="Daily Homework is required")
    private String dailyHomework;




    public int getId()
    {
        return curriculaId;
    }
    public void setId(int curriculaId)
    {
        this.curriculaId = curriculaId;
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

    public Curricula(String curriculaName, String dailyInstruction, String dailyHomework) {
        this.curriculaName = curriculaName;
        this.dailyInstruction = dailyInstruction;
        this.dailyHomework = dailyHomework;
    }

    public Curricula() {

    }
}

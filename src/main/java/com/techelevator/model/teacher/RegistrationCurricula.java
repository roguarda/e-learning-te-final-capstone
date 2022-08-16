package com.techelevator.model.teacher;

import org.hibernate.validator.constraints.NotBlank;

public class RegistrationCurricula {

    @NotBlank(message="Introduction is required")
    private String Introduction;
    public String getIntroduction() {
        return Introduction;
    }
    public void setIntroduction(String introduction) {
        this.Introduction = introduction;
    }

    @NotBlank(message="Daily Instruction is required")
    private String DailyInstruction;
    public String getDailyInstruction() { return DailyHomework;}
    public void setDailyInstruction(String dailyInstruction) {
        this.DailyInstruction = dailyInstruction;
    }


    @NotBlank(message="Daily Homework is required")
    private String DailyHomework;
    public String getDailyHomework() {
        return DailyHomework;
    }
    public void setDailyHomework(String dailyHomework) {
        this.DailyHomework = dailyHomework;
    }



}
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

    @NotBlank(message="Daily Homework is required")
    private String DailyHomework;
    public String getDailyHomework() {
        return DailyHomework;
    }
    public void setDailyHomework(String dailyHomework) {
        this.DailyHomework = dailyHomework;
    }



}
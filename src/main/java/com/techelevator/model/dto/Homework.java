package com.techelevator.model.dto;

import org.hibernate.validator.constraints.NotBlank;

public class Homework {

    private int id;

    @NotBlank(message = "Homework's name is required")
    private String homeworkName;

    @NotBlank(message = "Homework's introduction is required")
    private String homeworkIntroduction;

    @NotBlank(message = "Homework's Description is required")
    private String homeworkDescription;

    private String status;
    private boolean isCompleted;
    private String teacherFeedback;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHomeworkName() {
        return homeworkName;
    }

    public void setHomeworkName(String homeworkName) {
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


    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getTeacherFeedback() {
        return teacherFeedback;
    }

    public void setTeacherFeedback(String teacherFeedback) {
        this.teacherFeedback = teacherFeedback;
    }


}



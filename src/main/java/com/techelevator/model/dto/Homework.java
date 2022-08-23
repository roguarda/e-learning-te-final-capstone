package com.techelevator.model.dto;

public class Homework {

    private int id;
    String status;

    String introduction;

    String description;

    String teacherFeedback;

    boolean isCompleted;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String teacherFeedback() {
        return teacherFeedback;
    }

    public void teacherFeedback(String teacherFeedback) {
        this.teacherFeedback = teacherFeedback;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}

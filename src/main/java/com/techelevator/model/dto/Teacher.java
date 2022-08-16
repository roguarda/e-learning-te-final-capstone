package com.techelevator.model.dto;

import org.hibernate.validator.constraints.NotBlank;

public class Teacher {

    private int id;

    @NotBlank(message = "Name is required")

    private String teacherName;

    public String getTeacherName() {
        return teacherName;
    }


    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }


}

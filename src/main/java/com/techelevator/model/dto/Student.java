package com.techelevator.model.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Student {
    private int id;

    @NotBlank(message = "Name is required")

    private String studentName;

    public String getStudentName() {
        return studentName;
    }


    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
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


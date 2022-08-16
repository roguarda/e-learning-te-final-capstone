package com.techelevator.model.dao.jdbc;

import com.techelevator.model.dao.CourseDAO;
import com.techelevator.model.dto.Course;

import java.util.List;

public class JDBCCourseDAO implements CourseDAO {
    @Override
    public List<Course> getAllCourse() {
        return null;
    }

    @Override
    public List<Course> search(String idcourse) {
        return null;
    }

    @Override
    public Course getById(int idcourse) {
        return null;
    }

    @Override
    public Course add(Course course) {
        return null;
    }

    @Override
    public void update(int idcourse, Course course) {

    }

    @Override
    public void delete(int idcourse) {

    }
}

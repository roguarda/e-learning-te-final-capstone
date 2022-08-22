package com.techelevator.model.dao.jdbc;

import com.techelevator.model.dao.CourseDAO;
import com.techelevator.model.dto.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCCourseDAO implements CourseDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCCourseDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Course mapRowToCourses(SqlRowSet results) {
        Course course = new Course();
        course.setId(results.getInt("course_id"));
        course.setName(results.getString("course_name"));
        course.setDescription(results.getString("course_description"));
        course.setDifficultyLevel(results.getString("difficulty"));
        course.setCost(results.getString("cost"));
        course.setTeacherId(results.getInt("teacher_id"));


        return course;
    }

    @Override
    public List<Course> getAllCourse() {

        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * " +
                " FROM course;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            courses.add(mapRowToCourses(results));
        }
        return courses;
    }

    @Override
    public List<Course> search(String courseId) {
        return null;
    }

    @Override
    public Course getById(int courseId) {
        Course course = null;

        String sql = "SELECT course_id " + ", course_name " + ", course_description" + ", difficulty" + ", cost " +
                " FROM course " +
                " WHERE course_id = ? ; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, courseId);
        if (results.next()) {
            course = mapRowToCourses(results);
        }
        return course;
    }

    @Override
    public Course add(String courseName,int teacherId, String description, String difficultyLevel, String cost) {
        Course newCourse = new Course();
        jdbcTemplate.update("INSERT INTO course (course_name,\n" +
                        "                    teacher_id,\n" +
                        "                    course_description,\n" +
                        "                    difficulty,\n" +
                        "                    cost)\n" +
                        "VALUES (?, ?, ?, ?,?);",
                courseName, teacherId, description, difficultyLevel, cost);
        return newCourse;
    }

    @Override
    public void update(int idcourse, Course course) {

    }

    @Override
    public void delete(int idcourse) {

    }


}

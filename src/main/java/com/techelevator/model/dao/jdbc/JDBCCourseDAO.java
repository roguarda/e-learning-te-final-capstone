package com.techelevator.model.dao.jdbc;

import com.techelevator.model.dao.CourseDAO;
import com.techelevator.model.dto.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component

public class JDBCCourseDAO implements CourseDAO {

    static JdbcTemplate jdbcTemplate;

    public JDBCCourseDAO (DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Course> getAllCourse() {

        List<Course> courses = new ArrayList<>();
        String sql = "SELECT course_id " + ", course_name " + ", course_description" + ", difficulty" + ", cost " +
                " FROM course;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            courses.add(mapRowToCourses(results));
        }

        return courses;
    }

    private Course mapRowToCourses(SqlRowSet results) {
        Course course = new Course();
        course.setId(results.getInt("course_id"));
        course.setName(results.getString("course_id"));
        course.setDescription(results.getString("course_description"));
        course.setDifficultyLevel(results.getString("course_difficultyLevel"));
        course.setCost(results.getString("course_cost"));

        return  course;
    }

    @Override
    public List<Course> search(String idcourse) {
        return null;
    }

    @Override
    public Course getById(int idcourse) {Course course = null;

        String sql = "SELECT course_id " + ", course_name " + ", course_description" + ", difficulty" + ", cost " +
                " FROM course " +
                " WHERE course_id = ? ; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, idcourse);
        if (results.next()) {
            course = mapRowToCourses(results);
        }
        return course;
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

package com.techelevator.model.dao;

import com.techelevator.model.dto.Course;

import java.util.List;

public interface CourseDAO {

	List<Course> getAllCourse();

	List<Course> search (String idcourse);

	Course getById(int idcourse);



	Course add(String courseName, int teacherId, String description, String difficultyLevel, String cost);

	void update(int idcourse, Course course);

	void delete(int idcourse);

}

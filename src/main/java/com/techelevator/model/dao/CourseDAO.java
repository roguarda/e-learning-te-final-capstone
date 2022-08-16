package com.techelevator.model.dao;

import com.techelevator.model.dto.Course;

import java.util.List;

public interface CourseDAO {

	List<Course> getAllCourse();

	List<Course> search (String idcourse);

	Course getById(int idcourse);

	Course add(Course course);

	void update(int idcourse, Course course);

	void delete(int idcourse);

}

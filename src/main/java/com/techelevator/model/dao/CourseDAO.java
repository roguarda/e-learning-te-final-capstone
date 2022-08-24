package com.techelevator.model.dao;

import com.techelevator.model.dto.Course;

import java.util.List;

public interface CourseDAO {

	List<Course> getAllCourse();

	List<Course> search (String idcourse);

	Course getById(int courseId);

	Course add(String courseName, int teacherId, String description, String difficultyLevel, String cost);

	void update(String updateCriteria, String newValue, int courseId);

	void delete(int courseId);

	List<Course> findAllEnrolled(int studentId);

	List<Course> findAllMyCourses(long teacherId);
}

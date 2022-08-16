package com.techelevator.model.dao;

import com.techelevator.model.dto.Teacher;

import java.util.List;

public interface TeacherDAO {

	List<Teacher> getAllTeacher();

	List<Teacher> search (String id);

	Teacher getById(int id);

	Teacher add(Teacher teacher);

	void update(int id, Teacher teacher);

	void delete(int id);

}

package com.techelevator.model.dao;

import com.techelevator.model.dto.Student;

import java.util.List;

public interface StudentDAO {

	List<Student> getAllStudent();

	List<Student> search (String id);

	Student getById(int id);

	Student add(Student student);

	void update(int id, Student student);

	void delete(int id);

}

package com.techelevator.model.dao;

import com.techelevator.model.dto.Homework;

import java.util.List;

public interface HomeworkDAO {

	List<Homework> getAllHomework();

	List<Homework> search (String id);

	Homework getById(int id);

	Homework add(Homework homework);

	void update(int id, Homework homework);

	void delete(int id);

	public void add(String homeworkName, String homeworkIntroduction, String homeworkDescription);


}

package com.techelevator.model.dao;

import com.techelevator.model.dto.Homework;

import java.util.List;

public interface HomeworkDAO {

	//metodo que usa el alumno para subir la tarea
	void submitHomework(String title, String introduction, String description);

	// metodo que usa el maestro para corregir y dar devolucion
	void gradeHomework(int grade, String teacherFeedback, String status, int homeworkId);

	List<Homework> getHomeworkListByUserId(int userId);

	List<Homework> getHomeworkListByStatusAndTeacherId(int userId);

	List<Homework> getAllHomework();

	List<Homework> search (String id);

	Homework getById(int id);

	Homework add(Homework homework);

	void update(int id, Homework homework);

	//si el maestro devuelve la nota y esta mal, la corrige el alumno desde acá
	void rectifyHomework(int homeworkId, String newValue);

	void delete(int id);

	public void add(String homeworkName, String homeworkIntroduction, String homeworkDescription);




	List<Homework> getHomeworkListByCourseId(int courseId);

	public void add(String teacherFeedback, int homeworkGrade, String status);
}

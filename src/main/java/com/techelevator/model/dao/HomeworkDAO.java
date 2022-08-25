package com.techelevator.model.dao;

import com.techelevator.model.dto.Homework;

import java.util.List;

public interface HomeworkDAO {

	//metodo que usa el alumno para subir la tarea
	void submitHomework(String title, String introduction, String description);

	// metodo que usa el maestro para corregir y dar devolucion
	void gradeHomework(int grade, String teacherFeedback, String status, int homeworkId);


	void createHomework(String homeworkName, String homeworkInstruction);

	List<Homework> getHomeworkListByUserId(int userId);

	List<Homework> getHomeworkListByStatusAndTeacherId(int userId);

    List<Homework> getHomeworkListToGrade();

    List<Homework> getAllHomework();

	List<Homework> search (String id);

	Homework getById(int id);


	void submitHomework( String homeworkIntro, String homeworkDescription, int id);

	//si el maestro devuelve la nota y esta mal, la corrige el alumno desde acá
	void rectifyHomework(int homeworkId, String newValue);

	void delete(int id);

	List<Homework> getHomeworkListByCourseId(int courseId);

}

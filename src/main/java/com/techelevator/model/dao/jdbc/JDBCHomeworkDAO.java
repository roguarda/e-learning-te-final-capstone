package com.techelevator.model.dao.jdbc;

import com.techelevator.model.dao.HomeworkDAO;
import com.techelevator.model.dto.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCHomeworkDAO implements HomeworkDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCHomeworkDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Homework mapRowToHomework(SqlRowSet rowSet) {
        Homework homework = new Homework();

        homework.setId(rowSet.getInt("homework_id"));
        homework.setHomeworkName("homework_name");
        homework.setHomeworkIntroduction("homework_introduction");
        homework.setHomeworkDescription("homework_description");
        homework.setStatus(rowSet.getString("status"));
        homework.setCompleted(homework.getStatus().equals("completed"));
        homework.setTeacherFeedback("teacher_feedback");

        return homework;
    }


    //metodo que usa el alumno para subir la tarea
    @Override
    public void submitHomework(String title, String introduction, String description) {
        jdbcTemplate.update("INSERT INTO homework ( homework_name \n " +
                        "                      , homework_introduction \n " +
                        "                      , homework_description )\n " +
                        "       values (?, ?, ?);",
                title, introduction, description);

    }

    // metodo que usa el maestro para corregir y dar devolucion
    @Override
    public void gradeHomework(int grade, String teacherFeedback, String status, int homeworkId) {
        jdbcTemplate.update("UPDATE homework\n" +
                        "SET grade            = ?\n" +
                        "  , teacher_feedback = ?\n" +
                        "  , status           = ?\n" +
                        "WHERE homework_id = ?; ",
                grade, teacherFeedback, status, homeworkId);

    }

    //si el maestro devuelve la nota y esta mal, la corrige el alumno desde acá
    @Override
    public void rectifyHomework(int homeworkId, String newValue) {
        jdbcTemplate.update("UPDATE homework\n" +
                        "SET homework_introduction = '**EDITED** // ' || homework.homework_introduction\n" +
                        "  , homework_description= ?\n" +
                        "WHERE homework_id = ?;",
                newValue, homeworkId);
    }

    //metodo para ver las tareas de un curso
    @Override
    public List<Homework> getHomeworkListByCourseId(int courseId) {
        List<Homework> homeworkList = new ArrayList<>();
        String sql = "SELECT h.homework_id,\n" +
                "       h.homework_name,\n" +
                "       cu.daily_homework,\n" +
                "       h.homework_introduction,\n" +
                "       h.homework_description\n" +
                "FROM homework as h\n" +
                "         JOIN curricula_course cc ON h.curricula_id = cc.curricula_id\n" +
                "         JOIN curricula cu ON cu.curricula_id = cc.curricula_id\n" +
                "         JOIN course co ON co.course_id = cc.course_id\n" +
                "WHERE co.course_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, courseId);
        while (results.next()) {
            homeworkList.add(mapRowToHomework(results));
        }
        return homeworkList;
    }


    @Override
    public List<Homework> getAllHomework() {
        return null;
    }

    @Override
    public List<Homework> search(String id) {
        return null;
    }

    @Override
    public Homework getById(int id) {
        return null;
    }

    @Override
    public Homework add(Homework homework) {
        return null;
    }

    @Override
    public void update(int id, Homework homework) {

    }


    @Override
    public void delete(int id) {

    }

    @Override
    public void add(String homeworkName, String homeworkIntroduction, String homeworkDescription) {

    }

}


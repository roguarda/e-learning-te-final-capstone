package com.techelevator.model.dao.jdbc;
import com.techelevator.model.dao.HomeworkDAO;
import com.techelevator.model.dto.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;

@Component
public class JDBCHomeworkDAO implements HomeworkDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCHomeworkDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private User mapRowToHomework(SqlRowSet rowSet) {
        Homework homework = new Homework();
        homework.setId(rowSet.getInt("homework_id"));
        homework.setStatus(rowSet.getString("status"));
        if (homework.getStatus("completed")) {
            homework.setCompleted(true);
        } else homework.setDescription(false);

        user.setUserName(rowSet.getString("user_name"));
        user.setFirstName(rowSet.getString("first_name"));
        user.setLastName(rowSet.getString("last_name"));
        user.setRole(rowSet.getString("role"));
        return user;
    }
}


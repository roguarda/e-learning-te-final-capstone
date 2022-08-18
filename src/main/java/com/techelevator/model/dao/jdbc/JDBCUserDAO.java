package com.techelevator.model.dao.jdbc;

import javax.sql.DataSource;

import com.techelevator.model.dao.UserDAO;
import org.bouncycastle.util.encoders.Base64;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.dto.User;
import com.techelevator.services.security.PasswordHasher;

@Component
public class JDBCUserDAO implements UserDAO {

    private JdbcTemplate jdbcTemplate;
    private PasswordHasher hashMaster;

    @Autowired
    public JDBCUserDAO(DataSource dataSource, PasswordHasher hashMaster) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.hashMaster = hashMaster;
    }

    private User mapRowToUser(SqlRowSet rowSet) {
        User user = new User();
        user.setUserId(rowSet.getInt("user_id"));
        user.setUserName( rowSet.getString("user_name"));
        user.setFirstName(rowSet.getString("first_name"));
        user.setLastName(rowSet.getString("last_name"));
        user.setRole(rowSet.getString("role"));
        return user;
    }

    @Override
    public void saveUser(String userName, String password, String firstName, String lastName, String role) {
        byte[] salt = hashMaster.generateRandomSalt();
        String hashedPassword = hashMaster.computeHash(password, salt);
        String saltString = new String(Base64.encode(salt));

        boolean isStudent;
        boolean isTeacher;
        if(role.equals("student")){
            isStudent = true;
            isTeacher = false;
        } else {
            isStudent = false;
            isTeacher = true;
        }

        jdbcTemplate.update("INSERT INTO app_user(user_name, password, first_name, last_name, role, is_teacher, is_student, salt) " +
                        "VALUES (?,?,?,?,?,?,?,?);",
                userName, hashedPassword, firstName, lastName, role, isTeacher, isStudent, saltString);
    }

    @Override
    public boolean searchForUsernameAndPassword(String userName, String password) {
        String sqlSearchForUser = "SELECT * " +
                "FROM app_user " +
                "WHERE UPPER(user_name) = ? ";

        SqlRowSet user = jdbcTemplate.queryForRowSet(sqlSearchForUser, userName.toUpperCase());
        if (user.next()) {
            String dbSalt = user.getString("salt");
            String dbHashedPassword = user.getString("password");
            String givenPassword = hashMaster.computeHash(password, Base64.decode(dbSalt));
            return dbHashedPassword.equals(givenPassword);
        } else {
            return false;
        }
    }

    @Override
    public void updatePassword(String userName, String password) {
        jdbcTemplate.update("UPDATE app_user SET password = ? WHERE user_name = ?", password, userName);
    }

    @Override
    public Object getUserByUserName(String userName) {
        String sqlSearchForUsername = "SELECT * " +
                "FROM app_user " +
                "WHERE UPPER(user_name) = ? ";

        SqlRowSet user = jdbcTemplate.queryForRowSet(sqlSearchForUsername, userName.toUpperCase());
        User thisUser = null;
        if (user.next()) {
            thisUser = new User();
            thisUser.setUserName(user.getString("user_name"));
            thisUser.setPassword(user.getString("password"));
            thisUser.setStudent(user.getBoolean("is_student"));
            thisUser.setTeacher(user.getBoolean("is_teacher"));
            thisUser.setFirstName(user.getString("first_name"));
            thisUser.setLastName(user.getString("last_name"));
        }

        return thisUser;
    }

    @Override
    public Object getAttribute(String currentUser) {
        return null;
    }

    @Override
    public void updateName(String userName, String name) {

    }

    @Override
    public void updateAge(Object userAge, int age) {

    }

    @Override
    public void updateMail(Email userMail, Email mail) {

    }

}

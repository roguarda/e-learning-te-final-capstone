package com.techelevator.model.dao.jdbc;

import com.techelevator.model.dao.CurriculaDAO;
import com.techelevator.model.dto.Curricula;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JDBCCurriculaDAO implements CurriculaDAO {

    JdbcTemplate jdbcTemplate;

    private Employee mapRowToEmployee(SqlRowSet rowSet) {
        Employee employee = new Employee();
        employee.setId((long) rowSet.getInt("employee_id"));
        employee.setDepartmentId((long) rowSet.getInt("department_id"));
        employee.setFirstName(rowSet.getString("first_name"));
        employee.setLastName(rowSet.getString("last_name"));
        employee.setBirthDate(rowSet.getDate("birth_date").toLocalDate());
        employee.setHireDate(rowSet.getDate("hire_date").toLocalDate());
        return employee;
    }
    @Override
    public List<Curricula> getAllCurricula() {
        List<Curricula> curricula = new ArrayList<>();
        String sql = " SELECT curricula_id \n" +
                "     , curricula_name \n" +
                "     , daily_instruction \n" +
                "     , daily_homework \n" +
                " from curricula;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            curricula.add(mapRowToCurricula(results));
        }
        return curricula;
    }



    @Override
    public List<Curricula> search(String idcurricula) {
        return null;
    }

    @Override
    public Curricula getById(int idcurricula) {
        return null;
    }

    @Override
    public Curricula add(Curricula curricula) {
        return null;
    }

    @Override
    public void update(int idcurricula, Curricula curricula) {

    }

    @Override
    public void delete(int idcurricula) {

    }
}

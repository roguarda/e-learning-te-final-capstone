package com.techelevator.model.dao.jdbc;

import com.techelevator.model.dao.CurriculaDAO;
import com.techelevator.model.dto.Curricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCCurriculaDAO implements CurriculaDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCCurriculaDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Curricula mapRowToCurricula(SqlRowSet rowSet) {
        Curricula curricula = new Curricula();
        curricula.setId(rowSet.getInt("curricula_id"));
        curricula.setCurriculaName(rowSet.getString("curricula_name"));
        curricula.setDailyInstruction(rowSet.getString("daily_instruction"));
        curricula.setDailyHomework(rowSet.getString("daily_homework"));

        return curricula;
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
        while (results.next()) {
            curricula.add(mapRowToCurricula(results));
        }
        return curricula;
    }


    @Override
    public List<Curricula> search(String curriculaId) {
        return null;


    }

    @Override
    public Curricula getById(int curriculaId) {
        Curricula curricula = new Curricula();
        String sql = " SELECT curricula_id\n" +
                "           , curricula_name\n" +
                "           , daily_instruction\n" +
                "           , daily_homework\n" +
                "      from curricula\n" +
                "      WHERE curricula_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, curriculaId);
        if (results.next()) {
            curricula = mapRowToCurricula(results);
        }
        return curricula;
    }

    @Override
    public void add(String curriculaName, String dailyInstruction, String dailyHomework) {
        jdbcTemplate.update("INSERT INTO curricula ( curricula_name\n " +
                        "                      , daily_instruction\n " +
                        "                      , daily_homework)\n " +
                        "       values (?, ?, ?);",
                curriculaName, dailyInstruction, dailyHomework);
    }

    @Override
    public void update(int idcurricula, Curricula curricula) {

    }

    @Override
    public void delete(int idcurricula) {

    }
}

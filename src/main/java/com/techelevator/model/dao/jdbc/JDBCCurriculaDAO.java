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
        String sql = " SELECT curricula_id\n " +
                "     , curricula_name\n " +
                "     , daily_instruction\n " +
                "     , daily_homework\n " +
                " FROM curricula\n " +
                " ORDER BY curricula_id; ";
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
    public Curricula add(String curriculaName, String dailyInstruction, String dailyHomework) {
        Curricula curricula = new Curricula();
        jdbcTemplate.queryForObject("INSERT INTO curricula ( curricula_name\n " +
                        "                      , daily_instruction\n " +
                        "                      , daily_homework)\n " +
                        "       values (?, ?, ?)" +
                        " RETURNING daily_homework;",String.class,
                curriculaName, dailyInstruction, dailyHomework).toString();
        curricula.setCurriculaName(curriculaName);
        curricula.setDailyInstruction(dailyInstruction);
        curricula.setDailyHomework(dailyHomework);

        return curricula;

    }

    @Override
    public void update(String updateCriteria, String newValue, int curriculaId) {

        if (updateCriteria.equals("name")) {
            jdbcTemplate.update("update curricula SET curricula_name = ?\n" +
                    "where curricula_id = ?;", newValue, curriculaId);
        } else if (updateCriteria.equals("instruction")) {
            jdbcTemplate.update("update curricula SET daily_instruction = ?\n" +
                    "where curricula_id = ?;", newValue, curriculaId);
        } else jdbcTemplate.update("update curricula SET daily_homework = ?\n" +
                "where curricula_id = ?;", newValue, curriculaId);
    }

    @Override
    public void delete(int curriculaId) {
        String query = "DELETE FROM curricula\n" +
                "WHERE curricula_id = ?;";
        jdbcTemplate.update(query, curriculaId);
    }


    @Override
    public Curricula getCurriculaByCourseId(int courseId) {
        Curricula curricula = new Curricula();
        String query = "select *\n" +
                "from curricula \n" +
                "    inner join curricula_course  \n" +
                "        on  curricula.curricula_id = curricula_course.curricula_id \n" +
                "where curricula_course.course_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, courseId);
        while (rowSet.next()) {
            curricula = mapRowToCurricula(rowSet);
        }
        return curricula;
    }
}

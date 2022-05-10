package BentgrassLeague.dao;

import BentgrassLeague.model.GolfCourse;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcGolfCourseDao implements GolfCourseDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcGolfCourseDao(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public GolfCourse getGolfCourse(int golfCourseId) {
        GolfCourse golfCourse = null;
        String sql = "SELECT * FROM golf_course WHERE golf_course_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, golfCourseId);
        if (results.next()) {
            golfCourse = mapRowToGolfCourse(results);
        }
        return golfCourse;
    }


    @Override
    public List<GolfCourse> getAllGolfCourses() {
        List<GolfCourse> golfCourses = new ArrayList<>();
        String sql = "SELECT * FROM golf_course";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            golfCourses.add(mapRowToGolfCourse(results));
        }
        return golfCourses;
    }

    @Override
    public GolfCourse createGolfCourse(GolfCourse newGolfCourse) {
        String sql = "INSERT INTO golf_course (name, par, yardage, course_rating) " +
                "VALUES (?, ?, ?, ?) RETURNING golf_course_id;";
        int newId = jdbcTemplate.queryForObject(sql, Integer.class,
                newGolfCourse.getCourseName(), newGolfCourse.getPar(), newGolfCourse.getYardage(),
                newGolfCourse.getCourseRating());
        return getGolfCourse(newId);
    }

    @Override
    public void updateGolfCourse(GolfCourse updatedGolfCourse) {
        String sql = "UPDATE golf_course SET name = ?, par = ?, yardage = ?, course_rating = ?";
        jdbcTemplate.update(sql, updatedGolfCourse.getCourseName(), updatedGolfCourse.getPar(),
                updatedGolfCourse.getYardage(), updatedGolfCourse.getGolfCourseId());
    }

    public int getGolfCourseIdByName(String golfCourseName){
        int courseId = 0;
        try {
            String sql = "Select golf_course_id FROM golf_course" +
                    " Where name = ?";
            courseId = jdbcTemplate.queryForObject(sql, Integer.class, golfCourseName);
        } catch(DataAccessException e){
            e.getStackTrace();
        }
        return courseId;
    }



    @Override
    public void deleteGolfCourse(int golfCourseId) {
        String sql = "DELETE FROM golf_course WHERE golf_course_id = ?";
        jdbcTemplate.update(sql, golfCourseId);
    }

    private GolfCourse mapRowToGolfCourse(SqlRowSet rowSet) {
        GolfCourse golfCourse = new GolfCourse();
        golfCourse.setGolfCourseId(rowSet.getLong("golf_course_id"));
        golfCourse.setCourseName(rowSet.getString("name"));
        golfCourse.setPar(rowSet.getInt("par"));
        golfCourse.setYardage(rowSet.getInt("yardage"));
        golfCourse.setCourseRating(rowSet.getDouble("course_rating"));


        return golfCourse;
    }
}

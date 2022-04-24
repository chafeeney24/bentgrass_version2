package BentgrassLeague.dao;

import BentgrassLeague.model.GolfCourse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

public class JdbcGolfCourseDao implements GolfCourseDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcGolfCourseDao(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public GolfCourse getGolfCourse(Long golfCourseId) {
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
        return null;
    }

    @Override
    public GolfCourse createGolfCourse(GolfCourse newGolfCourse) {
        String sql = "INSERT INTO golf_course (name, par, yardage, course_rating) " +
                "VALUES (?, ?, ?, ?) RETURNING golf_course_id;";
        Long newId = jdbcTemplate.queryForObject(sql, Long.class,
                newGolfCourse.getCourseName(), newGolfCourse.getPar(), newGolfCourse.getYardage(),
                newGolfCourse.getCourseRating());
        return getGolfCourse(newId);
    }

    @Override
    public void updateGolfCourse(GolfCourse updatedGolfCourse) {

    }

    @Override
    public void addGolfCourseToRound(int roundId, int golfCourseId) {

    }

    @Override
    public void deleteGolfCourse(GolfCourse golfCourseToDelete) {

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

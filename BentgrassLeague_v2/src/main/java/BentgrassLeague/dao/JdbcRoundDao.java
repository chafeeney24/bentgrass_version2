package BentgrassLeague.dao;


import BentgrassLeague.model.Round;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

public class JdbcRoundDao implements RoundDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcRoundDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Round> getAllRounds() {
        return null;
    }

    @Override
    public List<Round> getRoundsByMember() {
        return null;
    }

    @Override
    public Round getRound(int roundId) {
        Round round = null;
        String sql = "SELECT * FROM round WHERE round_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, roundId);
        if(result.next()) {
            round = mapRowToRound(result);
        }
        return round;
    }

    @Override
    public Round addRound(Round round) {
        String sql = "INSERT INTO round (golf_course_id, round_score, round_type, date_played, member_id) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING round_id;";
        int newId = jdbcTemplate.queryForObject(sql, Integer.class, round.getGolfCourseId(), round.getRoundScore(),
                round.getRoundType(), round.getDateTimePlayed(), round.getMemberId());

        return getRound(newId);
    }

    @Override
    public void updateRound(Round round) {

    }

    @Override
    public void deleteRound(int roundId) {

    }

    @Override
    public void addRoundToTournament(int tournamentId, int roundId) {

    }

    private Round mapRowToRound(SqlRowSet rowSet) {
        Round round = new Round();
        round.setRoundId(rowSet.getInt("round_id"));
        round.setGolfCourseId(rowSet.getInt("golf_course_id"));
        round.setRoundScore(rowSet.getInt("round_score"));
        round.setDateTimePlayed(LocalDateTime.parse(rowSet.getString("date_played")));
        round.setMemberId(rowSet.getInt("member_id"));
        return round;
    }
}

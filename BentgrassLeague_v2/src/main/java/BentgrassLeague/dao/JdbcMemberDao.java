package BentgrassLeague.dao;

import BentgrassLeague.model.Member;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcMemberDao implements MemberDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    public Member getMember() {
        return null;
    }

    @Override
    public List<Member> getAllMembers() {
        return null;
    }

    @Override
    public List<Member> membersInTournament(int memberId, int tournamentId) {
        return null;
    }

    @Override
    public Member createMember() {
        return null;
    }
}

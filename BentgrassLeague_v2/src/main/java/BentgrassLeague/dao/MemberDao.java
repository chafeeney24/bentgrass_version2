package BentgrassLeague.dao;

import BentgrassLeague.model.Member;

import java.util.List;

public interface MemberDao {

    public Member getMember();

    public List<Member> getAllMembers();

    public List<Member> membersInTournament(int memberId, int tournamentId);

    public Member createMember();

}

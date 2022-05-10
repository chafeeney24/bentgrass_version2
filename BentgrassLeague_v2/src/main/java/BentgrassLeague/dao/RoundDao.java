package BentgrassLeague.dao;

import BentgrassLeague.model.Round;

import java.util.List;

public interface RoundDao {

    List<Round> getAllRounds();

    List<Round> getRoundsByMember();

    Round getRound(int roundId);

    Round addRound(Round round);

    void updateRound(Round round);

    void deleteRound(int roundId);

    void addRoundToTournament(int tournamentId, int roundId);
}

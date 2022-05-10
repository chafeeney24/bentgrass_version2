package BentgrassLeague.dao;

import BentgrassLeague.model.Tournament;

public interface TournamentDao {
    Tournament getTournament();

    Tournament getAllTournamentsForSeason();

    Tournament getAllTournamentsPlayed();

    Tournament addTournament(Tournament tournament);

    void updateTournament(Tournament tournament);

    void deleteTournament(int tournamentId);
}

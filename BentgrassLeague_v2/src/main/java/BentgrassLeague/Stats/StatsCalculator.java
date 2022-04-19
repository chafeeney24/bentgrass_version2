package BentgrassLeague.Stats;

import BentgrassLeague.model.Member;
import BentgrassLeague.model.Round;

import java.util.List;

public interface StatsCalculator {

    public List<Round> memberStats(Member member, List<Round> rounds);

}
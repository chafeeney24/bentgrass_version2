package BentgrassLeague.Stats;

import BentgrassLeague.dao.GolfCourseDao;
import BentgrassLeague.model.GolfCourse;
import BentgrassLeague.model.Member;
import BentgrassLeague.model.Round;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Handicap implements StatsCalculator{
    GolfCourseDao golfCourseDao;


    @Override
    public double memberStats(Member member, List<Round> rounds) {
        List<Round> memberRounds = member.getMemberRounds(rounds);
        List<Double> handicapDifferentials = new ArrayList<>();
        for (Round round : memberRounds) {
                GolfCourse golfCourse = golfCourseDao.getGolfCourse(round.getGolfCourseId());
                handicapDifferentials.add(round.getRoundScore() - golfCourse.getCourseRating());
        }

        double handicapIndex = 0.0;
        while (handicapDifferentials.size() >= 20) {
            handicapDifferentials.remove(0);
        }
        int length = handicapDifferentials.size();

        Collections.sort(handicapDifferentials);

        if (length < 5) {
            return 0.0;
        } else if (length <= 6) {
            handicapIndex = diffUsed(handicapDifferentials, 1);
            return -handicapIndex;
        } else if (length <= 8) {
            handicapIndex = diffUsed(handicapDifferentials, 2);
            return -handicapIndex;
        } else if (length <= 10) {
            handicapIndex = diffUsed(handicapDifferentials, 3);
            return -handicapIndex;
        } else if (length <= 12) {
            handicapIndex = diffUsed(handicapDifferentials, 4);
            return -handicapIndex;
        } else if (length <= 14) {
            handicapIndex = diffUsed(handicapDifferentials, 5);
            return -handicapIndex;
        } else if (length <= 16) {
            handicapIndex = diffUsed(handicapDifferentials, 6);
            return -handicapIndex;
        } else if (length == 17) {
            handicapIndex = diffUsed(handicapDifferentials, 7);
            return -handicapIndex;
        } else if (length == 18) {
            handicapIndex = diffUsed(handicapDifferentials, 8);
            return -handicapIndex;
        } else if (length == 19) {
            handicapIndex = diffUsed(handicapDifferentials, 9);
            return -handicapIndex;
        } else {
            handicapIndex = diffUsed(handicapDifferentials, 10);
            return -handicapIndex;
        }

    }

    public double diffUsed(List<Double> list, int differentialUsed) {
        int sum = 0;
        int avg = 0;
        final double HANDICAP_MULTIPLIER = 0.96;
        for (int i = 0; i < differentialUsed; i++) {
            sum += list.get(i);
        }
        avg = sum / differentialUsed;
        return avg * HANDICAP_MULTIPLIER;
    }


}

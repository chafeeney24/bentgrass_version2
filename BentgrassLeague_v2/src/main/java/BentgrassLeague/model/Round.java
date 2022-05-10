package BentgrassLeague.model;

import java.time.LocalDateTime;

public class Round {
    private int roundId;
    private int roundScore;
    private String roundType;
    private int golfCourseId;
    private int memberId;
    private LocalDateTime dateTimePlayed;


    public Round() {
    }

    public Round(int roundId, int roundScore, String resultType, int golfCourseId, int memberId) {
        this.roundId = roundId;
        this.roundScore = roundScore;
        this.roundType = resultType;
        this.golfCourseId = golfCourseId;
        this.memberId = memberId;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public int getRoundScore() {
        return roundScore;
    }

    public void setRoundScore(int roundScore) {
        this.roundScore = roundScore;
    }

    public String getRoundType() {
        return roundType;
    }

    public void setRoundType(String roundType) {
        this.roundType = roundType;
    }

    public int getGolfCourseId() {
        return golfCourseId;
    }

    public void setGolfCourseId(int golfCourseId) {
        this.golfCourseId = golfCourseId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getDateTimePlayed() {
        return dateTimePlayed;
    }

    public void setDateTimePlayed(LocalDateTime dateTimePlayed) {
        this.dateTimePlayed = dateTimePlayed;
    }

}

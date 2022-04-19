package BentgrassLeague.model;

public class Round {
    private Long roundId;
    private Long roundScore;
    private String resultType;
    private Long golfCourseid;

    public Round() {
    }

    public Round(Long roundId, Long roundScore, String resultType) {
        this.roundId = roundId;
        this.roundScore = roundScore;
        this.resultType = resultType;
    }

    public Long getRoundId() {
        return roundId;
    }

    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

    public Long getRoundScore() {
        return roundScore;
    }

    public void setRoundScore(Long roundScore) {
        this.roundScore = roundScore;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}

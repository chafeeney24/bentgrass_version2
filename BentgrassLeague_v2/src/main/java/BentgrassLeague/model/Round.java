package BentgrassLeague.model;

public class Round {
    private Long roundId;
    private Long roundScore;
    private String resultType;
    private Long golfCourseId;
    private long memberId;

    public Round() {
    }

    public Round(Long roundId, Long roundScore, String resultType, Long golfCourseid, Long memberId) {
        this.roundId = roundId;
        this.roundScore = roundScore;
        this.resultType = resultType;
        this.golfCourseId = golfCourseid;
        this.memberId = memberId;
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

    public Long getGolfCourseId() {
        return golfCourseId;
    }

    public void setGolfCourseId(Long golfCourseId) {
        this.golfCourseId = golfCourseId;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }
}

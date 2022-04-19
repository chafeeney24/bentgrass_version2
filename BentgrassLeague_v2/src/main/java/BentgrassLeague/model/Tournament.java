package BentgrassLeague.model;

import java.time.LocalDate;

public class Tournament {
    private Long id;
    private String name;
    private Long season_id;
    private String type;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Long roundsPlayed;

    public Tournament() {}

    public Tournament(Long id, String name, Long season_id, String type, LocalDate fromDate, LocalDate toDate, Long roundsPlayed) {
        this.id = id;
        this.name = name;
        this.season_id = season_id;
        this.type = type;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.roundsPlayed = roundsPlayed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSeason_id() {
        return season_id;
    }

    public void setSeason_id(Long golfCourseid) {
        this.season_id = golfCourseid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Long getRoundsPlayed() {
        return roundsPlayed;
    }

    public void setRoundsPlayed(Long roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }
}

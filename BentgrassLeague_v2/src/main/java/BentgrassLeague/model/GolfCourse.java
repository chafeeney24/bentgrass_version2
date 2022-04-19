package BentgrassLeague.model;

public class GolfCourse {
    private Long golfCourseId;
    private String courseName;
    private int par;
    private int yardage;
    private double courseRating;


    public GolfCourse() {
    }

    public GolfCourse(String courseName, int par, int yardage, double courseRating) {
        this.courseName = courseName;
        this.par = par;
        this.yardage = yardage;
        this.courseRating = courseRating;

    }

    public GolfCourse(Long golfCourseId, String courseName, int par, int yardage, double courseRating) {
        this.golfCourseId = golfCourseId;
        this.courseName = courseName;
        this.par = par;
        this.yardage = yardage;
        this.courseRating = courseRating;

    }

    public Long getGolfCourseId() {
        return golfCourseId;
    }

    public void setGolfCourseId(Long golfCourseId) {
        this.golfCourseId = golfCourseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public int getYardage() {
        return yardage;
    }

    public void setYardage(int yardage) {
        this.yardage = yardage;
    }

    public double getCourseRating() {
        return courseRating;
    }

    public void setCourseRating(double courseRating) {
        this.courseRating = courseRating;
    }
}



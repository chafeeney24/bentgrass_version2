package BentgrassLeague.dao;

import BentgrassLeague.model.GolfCourse;

import java.util.List;

public interface GolfCourseDao {

    public GolfCourse getGolfCourse(int golfCourseId);
    public int getGolfCourseIdByName(String golfCourseName);
    public List<GolfCourse> getAllGolfCourses();

    public GolfCourse createGolfCourse(GolfCourse newGolfCourse);

    public void updateGolfCourse (GolfCourse updatedGolfCourse);

    public void deleteGolfCourse (int golfCourseId);

}

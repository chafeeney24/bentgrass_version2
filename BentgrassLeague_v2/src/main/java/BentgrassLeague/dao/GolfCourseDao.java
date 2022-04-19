package BentgrassLeague.dao;

import BentgrassLeague.model.GolfCourse;

import java.util.List;

public interface GolfCourseDao {

    public GolfCourse getGolfCourse(Long golfCourseId);

    public List<GolfCourse> getAllDepartments();

    public GolfCourse createGolfCourse(GolfCourse newGolfCourse);

    public void updateGolfCourse (GolfCourse updatedGolfCourse);

    public void addGolfCourseToRound(int roundId, int golfCourseId);

    public void deleteGolfCourse (GolfCourse golfCourseToDelete);




}

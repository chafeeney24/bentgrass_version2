package BentgrassLeague;

import BentgrassLeague.dao.GolfCourseDao;
import BentgrassLeague.dao.JdbcGolfCourseDao;
import BentgrassLeague.model.GolfCourse;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class BentgrassCLI {

    private List<GolfCourse> golfCourseList = new ArrayList<>();
    private final GolfCourseDao golfCourseDao;


    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/bentgrass_league");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        BentgrassCLI app = new BentgrassCLI(dataSource);
        app.run();



    }
    public BentgrassCLI(DataSource dataSource){
        golfCourseDao = new JdbcGolfCourseDao(dataSource);
    }

    private void run(){
        addCourse();

        GolfCourse course = null;
        for (GolfCourse golfCourse : golfCourseList) {
          course = golfCourseDao.createGolfCourse(golfCourse);
            System.out.println(course);
        }


    }

//    public void addCourse(){
//        golfCourseList.add(new GolfCourse("Safe Haven Shores TGCT", 71, 7154, 74.3));
//        golfCourseList.add(new GolfCourse("Sky Peaks Resort, Canada", 71, 6897, 79.4));
//        golfCourseList.add(new GolfCourse("Butter's Bay", 72, 7358, 73.4));
//        golfCourseList.add(new GolfCourse("Vintage Ranch", 72, 7451, 72.9));
//        golfCourseList.add(new GolfCourse("Whiskey Run", 73, 7285, 79.4));
//        //5
//        golfCourseList.add(new GolfCourse("Dakota Downs", 71, 7192, 74.8));
//        golfCourseList.add(new GolfCourse("Old Faroe Dunes", 71, 6976, 72.7));
//        golfCourseList.add(new GolfCourse("Oasis Beach Golf Club", 72, 7599, 78.4));
//        golfCourseList.add(new GolfCourse("Rising Fawn Country Club", 72, 7184, 78.8));
//        golfCourseList.add(new GolfCourse("Remanent 1824", 72, 7451, 76.8));
//        //10
//        golfCourseList.add(new GolfCourse("The Ramparts at Harp Head", 72, 7255, 75.9));
//        golfCourseList.add(new GolfCourse("Redtail River", 72, 7532, 73.2));
//        golfCourseList.add(new GolfCourse("Yeti Creek CC - Black", 72, 7413, 78.6));
//    }

    
}

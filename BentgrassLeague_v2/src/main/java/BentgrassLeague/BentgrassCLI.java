package BentgrassLeague;

import BentgrassLeague.Stats.Handicap;
import BentgrassLeague.Stats.StatsCalculator;
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
    private StatsCalculator stats;

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



    }
    
}

package is.hi.f1a;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LeagueTest {
    @Test
    public void testSchedule() {
        Team arsenal = new Team("Arsenal");
        Team chelsea = new Team("Chelsea");
        Team manchesterCity = new Team("Manchester City");
        Team manchesterUnited = new Team("Manchester United");
        Team southampton = new Team("Southampton");
        Team liverpool = new Team("Liverpool");
        Team tottenham = new Team("Tottenham");
        Team swansea = new Team("Swansea");
        Team westHam = new Team("West Ham");
        Team stoke = new Team("Stoke");
        ArrayList<Team> teams = new ArrayList<Team>(Arrays.asList(arsenal, chelsea, manchesterCity, manchesterUnited, southampton, liverpool, tottenham, swansea, westHam, stoke));
        League league = new League(teams);
        assertEquals(league.getGames().size(), 90);
    }
}

package is.hi.f1a;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class DataRetrieverTest {
    @Test
    public void testGetTeams() {
        try {
            assertEquals(DataRetriever.getTeams().size(), 10);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void testGetPlayers() {
        try {
            ArrayList<Team> teams = DataRetriever.getTeams();
            DataRetriever.addPlayers(teams);
            for(Team t : teams) {
                assertTrue(t.getPlayers().size() > 10);
            }
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
package is.hi.f1a;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FantasyFootballBackendTest {
    @Test
    public void testGetLeague() {
        try {
            FantasyFootballBackend fantasyFootballBackend = FantasyFootballBackend.getInstance();
            League league = fantasyFootballBackend.getLeague();
            assertEquals(league.getTeams().size(), 10);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}

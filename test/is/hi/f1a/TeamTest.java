package is.hi.f1a;

import org.junit.Test;

public class TeamTest {
    @Test
    public void testStartingTeam() {
        Team manchesterUnited = new Team("Manchester United");
        Player arnor = new Player("Arnór", Player.Position.DEFENDER, 100, 10, 1, 1, 1, 1, 1, 1, 1, 1);
        arnor.calculatePrice(new MockPriceCalculation());

        manchesterUnited.addPlayer(arnor);
        // etc.
    }
}

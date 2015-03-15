package is.hi.f1a;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class TeamTest {
    @Test
    public void testStartingTeam() {
        Team manchesterUnited = new Team("Manchester United");

        Player DeGea = new Player("De Gea", Player.Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0);
        DeGea.calculatePrice(new MockPriceCalculation());
        Player Valdes = new Player("Valdes", Player.Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0);
        Valdes.calculatePrice(new MockPriceCalculation());
        Player Lindegaard = new Player("Lindegaard", Player.Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0);
        Lindegaard.calculatePrice(new MockPriceCalculation());
        Player Smalling = new Player("Smalling", Player.Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0);
        Smalling.calculatePrice(new MockPriceCalculation());
        Player Jones = new Player("Jones", Player.Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0);
        Jones.calculatePrice(new MockPriceCalculation());
        Player Rojo = new Player("Rojo", Player.Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0);
        Rojo.calculatePrice(new MockPriceCalculation());
        Player Evans = new Player("Evans", Player.Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0);
        Evans.calculatePrice(new MockPriceCalculation());
        Player Rafael = new Player("Rafael", Player.Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0);
        Rafael.calculatePrice(new MockPriceCalculation());
        Player Shaw = new Player("Shaw", Player.Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0);
        Shaw.calculatePrice(new MockPriceCalculation());
        Player Blind = new Player("Blind", Player.Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 29, 0);
        Blind.calculatePrice(new MockPriceCalculation());
        Player DiMaria = new Player("Di Maria", Player.Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 42, 0);
        DiMaria.calculatePrice(new MockPriceCalculation());
        Player Mata = new Player("Mata", Player.Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 33, 0);
        Mata.calculatePrice(new MockPriceCalculation());
        Player Valencia = new Player("Valencia", Player.Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0);
        Valencia.calculatePrice(new MockPriceCalculation());
        Player Fellaini = new Player("Fellaini", Player.Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0);
        Fellaini.calculatePrice(new MockPriceCalculation());
        Player Carrick = new Player("Carrick", Player.Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0);
        Carrick.calculatePrice(new MockPriceCalculation());
        Player Januzaj = new Player("Januzaj", Player.Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 18, 0);
        Januzaj.calculatePrice(new MockPriceCalculation());
        Player Herrera = new Player("Herrera", Player.Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0);
        Herrera.calculatePrice(new MockPriceCalculation());
        Player Young = new Player("Youngr", Player.Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0);
        Young.calculatePrice(new MockPriceCalculation());
        Player Rooney = new Player("Rooney", Player.Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 50, 0);
        Rooney.calculatePrice(new MockPriceCalculation());
        Player VanPersie = new Player("Van Persie", Player.Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0);
        VanPersie.calculatePrice(new MockPriceCalculation());
        Player Falcao = new Player("Falcao", Player.Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 40, 0);
        Falcao.calculatePrice(new MockPriceCalculation());
        Player Wilson = new Player("Wilson", Player.Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0);
        Wilson.calculatePrice(new MockPriceCalculation());

        manchesterUnited.addPlayer(DeGea);
        manchesterUnited.addPlayer(Valdes);
        manchesterUnited.addPlayer(Lindegaard);
        manchesterUnited.addPlayer(Smalling);
        manchesterUnited.addPlayer(Jones);
        manchesterUnited.addPlayer(Shaw);
        manchesterUnited.addPlayer(Rafael);
        manchesterUnited.addPlayer(Blind);
        manchesterUnited.addPlayer(Rojo);
        manchesterUnited.addPlayer(Evans);
        manchesterUnited.addPlayer(DiMaria);
        manchesterUnited.addPlayer(Fellaini);
        manchesterUnited.addPlayer(Carrick);
        manchesterUnited.addPlayer(Januzaj);
        manchesterUnited.addPlayer(Herrera);
        manchesterUnited.addPlayer(Mata);
        manchesterUnited.addPlayer(Valencia);
        manchesterUnited.addPlayer(Rooney);
        manchesterUnited.addPlayer(VanPersie);
        manchesterUnited.addPlayer(Falcao);
        manchesterUnited.addPlayer(Wilson);

        ArrayList<Player> manU = new ArrayList<Player>();
        manU = manchesterUnited.calculateStartingTeam();

        for(int i = 0; i < manU.size(); i++){
            System.out.println(manU.get(i).toString());
        }

        int j = 0;

        assertEquals(manU.get(0), DeGea);
        assertEquals(manU.get(1), Blind);
        assertEquals(manU.get(2), Rojo);
        assertEquals(manU.get(3), Shaw);
        if(manU.get(4).getPosition()== Player.Position.MIDFIELDER)
            j=4;
        else if(manU.get(4).getPosition()== Player.Position.MIDFIELDER)
            j=5;
        else
            j=6;
        assertEquals(manU.get(j), DiMaria);
        assertEquals(manU.get(j+1), Mata);
        assertEquals(manU.get(j+2), Herrera);
        assertEquals(manU.get(11), Valdes);

        DeGea.setRedCards(1);
        manU = manchesterUnited.calculateStartingTeam();
        assertEquals(manU.get(0), Valdes);

        DeGea.setRedCards(0);
        Valdes.setInjuryLength(1);
        manU = manchesterUnited.calculateStartingTeam();
        assertEquals(manU.get(11), Lindegaard);

        for(int i = 0; i < manU.size(); i++){
            System.out.println(manU.get(i).toString());
        }






        // etc.
    }
}

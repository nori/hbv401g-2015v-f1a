package is.hi.f1a;

import org.junit.Test;

import java.util.ArrayList;

public class TeamTest {
    @Test
    public void testStartingTeam() {
        Team manchesterUnited = new Team("Manchester United");

        Player DeGea = new Player("De Gea", Player.Position.GOALKEEPER, 100, 10, 1, 1, 1, 1, 1, 1, 20, 1);
        DeGea.calculatePrice(new MockPriceCalculation());
        Player Valdes = new Player("Valdes", Player.Position.GOALKEEPER, 100, 10, 1, 1, 1, 1, 1, 1, 10, 1);
        Valdes.calculatePrice(new MockPriceCalculation());
        Player Smalling = new Player("Smalling", Player.Position.DEFENDER, 100, 10, 1, 1, 1, 1, 1, 1, 25, 1);
        Smalling.calculatePrice(new MockPriceCalculation());
        Player Jones = new Player("Jones", Player.Position.DEFENDER, 100, 10, 1, 1, 1, 1, 1, 1, 20, 1);
        Jones.calculatePrice(new MockPriceCalculation());
        Player Rojo = new Player("Rojo", Player.Position.DEFENDER, 100, 10, 1, 1, 1, 1, 1, 1, 15, 1);
        Rojo.calculatePrice(new MockPriceCalculation());
        Player Evans = new Player("Evans", Player.Position.DEFENDER, 100, 10, 1, 1, 1, 1, 1, 1, 5, 1);
        Evans.calculatePrice(new MockPriceCalculation());
        Player Rafael = new Player("Rafael", Player.Position.DEFENDER, 100, 10, 1, 1, 1, 1, 1, 1, 7, 1);
        Rafael.calculatePrice(new MockPriceCalculation());
        Player Shaw = new Player("Shaw", Player.Position.DEFENDER, 100, 10, 1, 1, 1, 1, 1, 1, 22, 1);
        Shaw.calculatePrice(new MockPriceCalculation());
        Player Blind = new Player("Blind", Player.Position.DEFENDER, 100, 10, 1, 1, 1, 1, 1, 1, 18, 1);
        Blind.calculatePrice(new MockPriceCalculation());
        Player DiMaria = new Player("Di María", Player.Position.MIDFIELDER, 100, 10, 1, 1, 1, 1, 1, 1, 50, 1);
        DiMaria.calculatePrice(new MockPriceCalculation());
        Player Mata = new Player("Mata", Player.Position.MIDFIELDER, 100, 10, 1, 1, 1, 1, 1, 1, 25, 1);
        Mata.calculatePrice(new MockPriceCalculation());
        Player Valencia = new Player("Valencia", Player.Position.MIDFIELDER, 100, 10, 1, 1, 1, 1, 1, 1, 7, 1);
        Valencia.calculatePrice(new MockPriceCalculation());
        Player Fellaini = new Player("Fellaini", Player.Position.MIDFIELDER, 100, 10, 1, 1, 1, 1, 1, 1, 28, 1);
        Fellaini.calculatePrice(new MockPriceCalculation());
        Player Carrick = new Player("Carrick", Player.Position.MIDFIELDER, 100, 10, 1, 1, 1, 1, 1, 1, 10, 1);
        Carrick.calculatePrice(new MockPriceCalculation());
        Player Januzaj = new Player("Januzaj", Player.Position.MIDFIELDER, 100, 10, 1, 1, 1, 1, 1, 1, 15, 1);
        Januzaj.calculatePrice(new MockPriceCalculation());
        Player Herrera = new Player("Herrera", Player.Position.MIDFIELDER, 100, 10, 1, 1, 1, 1, 1, 1, 22, 1);
        Herrera.calculatePrice(new MockPriceCalculation());
        Player Young = new Player("Youngr", Player.Position.MIDFIELDER, 100, 10, 1, 1, 1, 1, 1, 1, 8, 1);
        Young.calculatePrice(new MockPriceCalculation());
        Player Rooney = new Player("Rooney", Player.Position.FORWARD, 100, 10, 1, 1, 1, 1, 1, 1, 35, 1);
        Rooney.calculatePrice(new MockPriceCalculation());
        Player VanPersie = new Player("Van Persie", Player.Position.FORWARD, 100, 10, 1, 1, 1, 1, 1, 1, 15, 1);
        VanPersie.calculatePrice(new MockPriceCalculation());
        Player Falcao = new Player("Falcao", Player.Position.FORWARD, 100, 10, 1, 1, 1, 1, 1, 1, 40, 1);
        Falcao.calculatePrice(new MockPriceCalculation());
        Player Wilson = new Player("Wilson", Player.Position.FORWARD, 100, 10, 1, 1, 1, 1, 1, 1, 10, 1);
        Wilson.calculatePrice(new MockPriceCalculation());

        manchesterUnited.addPlayer(DeGea);
        manchesterUnited.addPlayer(Valdes);
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


        // etc.
    }
}

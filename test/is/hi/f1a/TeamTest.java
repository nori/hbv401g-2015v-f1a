package is.hi.f1a;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class TeamTest {
    @Test
    public void testStartingTeam() {
        Team manchesterUnited = new Team("Manchester United");

        Player DeGea = new Player("De Gea", Player.Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, "");
        DeGea.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Valdes = new Player("Valdes", Player.Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, "");
        Valdes.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Lindegaard = new Player("Lindegaard", Player.Position.GOALKEEPER, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, "");
        Lindegaard.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Smalling = new Player("Smalling", Player.Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, "");
        Smalling.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Jones = new Player("Jones", Player.Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, "");
        Jones.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Rojo = new Player("Rojo", Player.Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0, "");
        Rojo.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Evans = new Player("Evans", Player.Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, "");
        Evans.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Rafael = new Player("Rafael", Player.Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0, "");
        Rafael.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Shaw = new Player("Shaw", Player.Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0, "");
        Shaw.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Blind = new Player("Blind", Player.Position.DEFENDER, 0, 0, 0, 0, 0, 0, 0, 0, 29, 0, "");
        Blind.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player DiMaria = new Player("Di Maria", Player.Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 42, 0, "");
        DiMaria.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Mata = new Player("Mata", Player.Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 33, 0, "");
        Mata.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Valencia = new Player("Valencia", Player.Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, "");
        Valencia.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Fellaini = new Player("Fellaini", Player.Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, "");
        Fellaini.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Carrick = new Player("Carrick", Player.Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, "");
        Carrick.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Januzaj = new Player("Januzaj", Player.Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 18, 0, "");
        Januzaj.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Herrera = new Player("Herrera", Player.Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, "");
        Herrera.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Young = new Player("Youngr", Player.Position.MIDFIELDER, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, "");
        Young.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Rooney = new Player("Rooney", Player.Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 50, 0, "");
        Rooney.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player VanPersie = new Player("Van Persie", Player.Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, "");
        VanPersie.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Falcao = new Player("Falcao", Player.Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 40, 0, "");
        Falcao.calculateSkill(new MockSkillCalculation(), 10, 10);
        Player Wilson = new Player("Wilson", Player.Position.FORWARD, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, "");
        Wilson.calculateSkill(new MockSkillCalculation(), 10, 10);

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

        assertEquals(manU.get(0), DeGea);
        assertEquals(manU.get(1), Blind);
        assertEquals(manU.get(2), Rojo);
        assertEquals(manU.get(3), Shaw);
        int j = 0;
        if(manU.get(4).getPosition() == Player.Position.MIDFIELDER) {
            j = 4;
        } else if(manU.get(5).getPosition() == Player.Position.MIDFIELDER) {
            j = 5;
        } else {
            j = 6;
        }
        assertEquals(manU.get(j), DiMaria);
        assertEquals(manU.get(j+1), Mata);
        assertEquals(manU.get(j+2), Herrera);
        assertEquals(manU.get(11), Valdes);

        DeGea.setRedCards(1);
        manU = manchesterUnited.calculateStartingTeam();
        assertEquals(manU.get(0), Valdes);

        DeGea.setRedCards(1);
        Valdes.setInjuryLength(0);
        manU = manchesterUnited.calculateStartingTeam();
        assertEquals(manU.get(11), Lindegaard);

    }
}

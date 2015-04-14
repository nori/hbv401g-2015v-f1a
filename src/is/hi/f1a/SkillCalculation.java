package is.hi.f1a;

public class SkillCalculation implements ISkillCalculation {

    @Override
    public int calculateSkill(Player player, double avgPoints, double avgSkill) {
        int nowPrice = player.getSkill();
        double factor = 0.2;
        return (int) (nowPrice + (player.getRecentPoints()-avgPoints)*factor*(avgSkill /nowPrice));

    }
}

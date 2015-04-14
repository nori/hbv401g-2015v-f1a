package is.hi.f1a;


public class MockSkillCalculation implements ISkillCalculation {
    @Override
    public int calculateSkill(Player player, double avgPoints, double avgSkill) {
        return player.getOriginalPrice();
    }
}

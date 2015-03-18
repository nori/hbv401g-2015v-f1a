package is.hi.f1a;


public class MockPriceCalculation implements IPriceCalculation {
    @Override
    public int calculatePrice(Player player, double avgPoints, double avgPrice) {
        return player.getOriginalPrice();
    }
}

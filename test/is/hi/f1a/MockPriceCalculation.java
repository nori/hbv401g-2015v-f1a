package is.hi.f1a;


public class MockPriceCalculation implements IPriceCalculation {
    @Override
    public int calculatePrice(Player player) {
        return player.getOriginalPrice();
    }
}

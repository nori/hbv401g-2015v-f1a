package is.hi.f1a;

public class PriceCalculation implements IPriceCalculation {

    @Override
    public int calculatePrice(Player player, double avgPoints, double avgPrice) {
        int nowPrice = player.getPrice();
        double factor = 0.2;
        return (int) (nowPrice + (player.getRecentPoints()-avgPoints)*factor*(avgPrice/nowPrice));

    }
}

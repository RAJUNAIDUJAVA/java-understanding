package oops.strategy;

public class FestiveDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double price) {
        return price*0.7;
    }
}

package oops.strategy;

public class Checkout {

    private DiscountStrategy strategy;

    public Checkout(DiscountStrategy strategy){
        this.strategy = strategy;
    }

    public Double calculateFinalPrice(double price){
        return strategy.applyDiscount(price);
    }
}

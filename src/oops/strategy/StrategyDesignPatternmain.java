package oops.strategy;

public class StrategyDesignPatternmain {

    public static void main(String[] args) {
        Checkout checkout = new Checkout(new FestiveDiscount());
        Double price =checkout.calculateFinalPrice(1500);
        System.out.println(price);
    }
}

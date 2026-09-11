package oops.factoryMethod;

public class CreditCardPayment implements Payment{
    @Override
    public String pay(double payment) {
        return "Credit Card payment";
    }
}

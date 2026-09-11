package oops.factoryMethod;

public class UPIPayment implements Payment{
    @Override
    public String pay(double payment) {
        return "UPI payment";
    }
}

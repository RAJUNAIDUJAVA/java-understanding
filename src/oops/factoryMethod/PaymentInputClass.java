package oops.factoryMethod;

public class PaymentInputClass {

    public static void main(String[] args) {
        Payment payment = PaymentFactoryClass.getPaymentMethod("CREDIT");
        String response =payment.pay(5000);
        System.out.println(response);
    }
}

package oops.factoryMethod;

public class PaymentFactoryClass {

        public static Payment getPaymentMethod(String type){
            if("UPI".equalsIgnoreCase(type)){
                return new UPIPayment();
            }
            else if("CREDIT".equalsIgnoreCase(type)){
                return new CreditCardPayment();
            }
            throw new IllegalArgumentException("Unknown Payment type");
        }
}

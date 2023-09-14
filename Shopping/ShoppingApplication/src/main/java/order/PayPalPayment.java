package order;

public class PayPalPayment implements IPaymentType{
    String emailAdress;

    public PayPalPayment(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    @Override
    public String toString() {
        return "PayPalPayment{" +
                "emailAdress='" + emailAdress + '\'' +
                '}';
    }
}

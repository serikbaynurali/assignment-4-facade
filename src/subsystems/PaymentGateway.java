package subsystems;

public class PaymentGateway {
    public boolean processPayment(String userId, double amount) {
        System.out.println("Processing payment of $" + amount + " for user " + userId);
        return true;
    }
}
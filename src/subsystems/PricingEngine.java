package subsystems;

public class PricingEngine {
    public double calculateTotal(String category, String promoCode) {
        double basePrice = category.equalsIgnoreCase("VIP") ? 150.0 : 50.0;
        System.out.println("Calculating price for " + category + " with promo " + promoCode);
        return basePrice;
    }
}
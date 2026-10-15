package Facade;
import subsystems.*;
public class TicketBookingFacade{
    private StadiumSeatAvailability seatAvailability;
    private PricingEngine pricingEngine;
    private PaymentGateway paymentGateway;
    private TicketFulfillmentService fulfillmentService;

    public TicketBookingFacade() {
        this.seatAvailability = new StadiumSeatAvailability();
        this.pricingEngine = new PricingEngine();
        this.paymentGateway = new PaymentGateway();
        this.fulfillmentService = new TicketFulfillmentService();
    }

    public String bookMatchTicket(String matchId, String userId, String category, String promoCode) {
        System.out.println("--- Starting Ticket Booking Workflow ---");

        boolean isAvailable = seatAvailability.checkAndHoldSeat(matchId, category);
        if (!isAvailable) {
            throw new RuntimeException("Selected seat category is sold out.");
        }

        double amount = pricingEngine.calculateTotal(category, promoCode);
        boolean paymentSuccess = paymentGateway.processPayment(userId, amount);

        if (!paymentSuccess) {
            throw new RuntimeException("Payment processing failed.");
        }

        String ticketId = fulfillmentService.generateAndSendTicket(userId, matchId);
        System.out.println("--- Booking Completed Successfully ---");

        return ticketId;
    }
}
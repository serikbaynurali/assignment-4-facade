package subsystems;

public class TicketFulfillmentService {
    public String generateAndSendTicket(String userId, String matchId) {

        System.out.println("Generating digital ticket barcode and sending confirmation email.");
        return "TICKET-PASS-998822";
    }
}
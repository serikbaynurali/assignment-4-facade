import Facade.*;
public class Main{
    public static void main(String[] args) {

            TicketBookingFacade bookingFacade = new TicketBookingFacade();

            String ticketId = bookingFacade.bookMatchTicket("MATCH-ElClasico-2026", "user_12345", "VIP", "WELCOME10");
            System.out.println("Issued Ticket ID: " + ticketId);
        }
    }


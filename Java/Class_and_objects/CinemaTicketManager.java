/*2.	A Cinema Hall has capacity of 100 seats and needs an automated system to manage ticket sales. Each movie show has a title, a ticket price, and a set number of available seats. The system should allow customers to check availability, book a specific number of tickets, and automatically calculate the total cost while updating the seating capacity */
package Class_and_objects;
import java.util.Scanner;

class MovieShow {
    private String title;
    private double ticketPrice;
    private int availableSeats;
    private static final int MAX_CAPACITY = 100;

    public MovieShow(String title, double ticketPrice) {
        this.title = title;
        this.ticketPrice = ticketPrice;
        this.availableSeats = MAX_CAPACITY; // Starts fully open
    }

    public String getTitle() {
        return title;
    }

    public void checkAvailability() {
        System.out.println("\n--- Current Seat Availability Status ---");
        System.out.println(" Movie Show   : " + title);
        System.out.println(" Ticket Price : ₹" + ticketPrice);
        System.out.println(" Available    : " + availableSeats + " / " + MAX_CAPACITY + " seats left");
        
        if (availableSeats == 0) {
            System.out.println(" Status       : HOUSEFULL");
        } else if (availableSeats <= 10) {
            System.out.println(" Status       : Filling Fast! Hurry up!");
        } else {
            System.out.println(" Status       : Good availability");
        }
    }

    public void bookTickets(int numberOfTickets) {

        if (numberOfTickets <= 0) {
            System.out.println(" Booking Error: You must book at least 1 ticket.");
            return;
        }

        if (numberOfTickets > availableSeats) {
            System.out.printf(" Transaction Denied: Insufficient seats remaining! Only %d seats available.%n", availableSeats);
            return;
        }

        double totalCost = numberOfTickets * ticketPrice;
        
        availableSeats -= numberOfTickets;

        System.out.println("\n --- Booking Confirmed! ---");
        System.out.println(" Movie    : " + title);
        System.out.println(" Tickets  : " + numberOfTickets);
        System.out.printf(" Total Due: ₹%.2f%n", totalCost);
        System.out.println(" Remaining Seats in Hall: " + availableSeats);
    }
}

public class CinemaTicketManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        MovieShow activeShow = new MovieShow("Inception (Sci-Fi Classic)", 250.00);

        while (true) {
            System.out.println("\n========================================");
            System.out.println("      CINEMA BOX OFFICE MANAGEMENT     ");
            System.out.println("========================================");
            System.out.println("1. Check Show Status & Seat Availability");
            System.out.println("2. Book Show Tickets");
            System.out.println("3. Exit System");
            System.out.print("Please enter your choice (1-3): ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    activeShow.checkAvailability();
                    break;
                    
                case 2:
                    System.out.print("Enter number of tickets you wish to purchase: ");
                    int ticketsToBuy = scanner.nextInt();
                    activeShow.bookTickets(ticketsToBuy);
                    break;
                    
                case 3:
                    System.out.println("Thank you for using our booking platform. Enjoy your movie!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid selection! Please enter a valid menu number (1-3).");
            }
        }
    }
}


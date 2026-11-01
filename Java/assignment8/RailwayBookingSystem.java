class TicketCounter {
    private int availableSeats = 1; 

    public synchronized void bookSeat(String passengerName) {
        System.out.println(passengerName + " is trying to book a seat...");
        
        if (availableSeats > 0) {
            System.out.println("Seat is available! Processing booking for " + passengerName + "...");
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            availableSeats--;
            System.out.println("Booking SUCCESSFUL for " + passengerName);
        } else {
            System.out.println("Booking FAILED for " + passengerName + ". Seat already booked!");
        }
    }
}

class Passenger extends Thread {
    private TicketCounter counter;
    private String name;

    public Passenger(TicketCounter counter, String name) {
        this.counter = counter;
        this.name = name;
    }

    @Override
    public void run() {
        counter.bookSeat(name);
    }
}

public class RailwayBookingSystem {
    public static void main(String[] args) {
        TicketCounter sharedCounter = new TicketCounter();
        Passenger user1 = new Passenger(sharedCounter, "User A");
        Passenger user2 = new Passenger(sharedCounter, "User B");

        user1.start();
        user2.start();
    }
}

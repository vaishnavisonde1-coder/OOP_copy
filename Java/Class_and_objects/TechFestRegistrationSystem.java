/*3.	An Engineering Students Club needs software to register participants for its annual Technical Fest. The workshop has a maximum seat capacity due to lab constraints. Each student participant has a unique registration ID, name, branch (e.g., Computer Science, Mechanical), and membership type (Club Member or Non-Member). The system needs to validate that the lab is not full before accepting a new registration, calculate the registration fee based on their membership status, and print workshop entry passes */
package Class_and_objects;
import java.util.Scanner;

class Participant {
    private String registrationId;
    private String name;
    private String branch;
    private String membershipType; // "Club Member" or "Non-Member"
    private double registrationFee;

    public Participant(String registrationId, String name, String branch, String membershipType) {
        this.registrationId = registrationId;
        this.name = name;
        this.branch = branch;
        this.membershipType = membershipType;
        this.registrationFee = calculateFee();
    }

    private double calculateFee() {
        if (membershipType.equalsIgnoreCase("Club Member")) {
            return 150.00; // Discounted rate for active members
        } else {
            return 300.00; // Standard flat rate for non-members
        }
    }

    public void printEntryPass() {
        System.out.println("\n========================================");
        System.out.println("       TECH FEST WORKSHOP ENTRY PASS    ");
        System.out.println("========================================");
        System.out.println(" Reg ID   : " + registrationId);
        System.out.println(" Name     : " + name);
        System.out.println(" Branch   : " + branch);
        System.out.println(" Status   : " + membershipType);
        System.out.printf(" Fee Paid : ₹%.2f (Verified)%n", registrationFee);
        System.out.println("----------------------------------------");
        System.out.println("Please show this pass at the lab gate.");
        System.out.println("========================================");
    }
}

class WorkshopManager {
    private Participant[] registrationPool;
    private int activeCount;
    private final int maxLabCapacity;

    public WorkshopManager(int capacity) {
        this.maxLabCapacity = capacity;
        this.registrationPool = new Participant[capacity];
        this.activeCount = 0;
    }

    public void registerStudent(String id, String name, String branch, String membership) {
        if (activeCount >= maxLabCapacity) {
            System.out.println("\n Registration Denied: The workshop lab has hit its maximum capacity!");
            System.out.println("Status: ALL SEATS BOOKED (" + maxLabCapacity + "/" + maxLabCapacity + ")");
            return;
        }

        Participant newStudent = new Participant(id, name, branch, membership);
        registrationPool[activeCount] = newStudent;
        activeCount++;

        System.out.println("\n Registration successful! Generating pass...");
        newStudent.printEntryPass();
    }

    public void displayStatus() {
        System.out.println("\n --- Lab Occupancy Tracker ---");
        System.out.println("Seats Occupied : " + activeCount);
        System.out.println("Seats Available: " + (maxLabCapacity - activeCount) + " / " + maxLabCapacity);
    }
}

public class TechFestRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter maximum lab capacity constraints for this workshop: ");
        int labLimit = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        
        WorkshopManager manager = new WorkshopManager(labLimit);

        while (true) {
            System.out.println("\n========================================");
            System.out.println("   ENGINEERING CLUB REGISTRATION DESK   ");
            System.out.println("========================================");
            System.out.println("1. Register New Student Participant");
            System.out.println("2. Check Lab Seat Availability Status");
            System.out.println("3. Shut Down Registration Portal");
            System.out.print("Enter your operational choice (1-3): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Unique Registration ID (e.g., REG101): ");
                    String id = scanner.nextLine();
                    
                    System.out.print("Enter Student Full Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter Academic Branch (e.g., CSE, ME): ");
                    String branch = scanner.nextLine();
                    
                    System.out.print("Enter Membership Type (1 for Club Member, 2 for Non-Member): ");
                    int typeChoice = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    
                    String membership = (typeChoice == 1) ? "Club Member" : "Non-Member";
                    
                    manager.registerStudent(id, name, branch, membership);
                    break;
                    
                case 2:
                    manager.displayStatus();
                    break;
                    
                case 3:
                    System.out.println("Closing portal. All local passes printed correctly. Have a great event!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid selection! Please key in a choice between 1 and 3.");
            }
        }
    }
}

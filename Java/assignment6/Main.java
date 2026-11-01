package assignment6;
/*1.	Surplus Food Donation Tracker
Scenario: A hostel mess and a nearby NGO shelter want to reduce food waste. The mess has leftover food every day, but nobody keeps a record of what is available or who received it.
Problem: Create a Donation class with attributes such as donor name, food item, quantity in kg, and status (available or collected). Create a DonationManager class that stores up to 50 donations in an array of objects.
Tasks:
•	Add a new donation using a constructor
•	Display all available donations
•	Mark a donation as collected (a method that updates the status)
•	Search donations by food item
•	Display the total kg of food saved
*/

import java.util.Scanner;

class Donation {
    private String donorName;
    private String foodItem;
    private double quantityKg;
    private String status; // "available" or "collected"

    public Donation(String donorName, String foodItem, double quantityKg) {
        this.donorName = donorName;
        this.foodItem = foodItem;
        this.quantityKg = quantityKg;
        this.status = "available"; 
    }

    public String getFoodItem() {
        return foodItem;
    }

    public double getQuantityKg() {
        return quantityKg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayDetails() {
        System.out.printf("Donor: %-15s | Item: %-15s | Qty: %-5.2f kg | Status: %s%n", 
                donorName, foodItem, quantityKg, status);
    }
}

class DonationManager {
    private Donation[] donations = new Donation[50];
    private int donationCount = 0;

    public void addDonation(String donorName, String foodItem, double quantityKg) {
        if (donationCount >= 50) {
            System.out.println("Too many donations already.");
            return;
        }
        donations[donationCount] = new Donation(donorName, foodItem, quantityKg);
        donationCount++;
        System.out.println("Food Donation Recorded!!");
    }

    public void displayAvailableDonations() {
        System.out.println("\n--- Available Food Donations ---");
        boolean found = false;
        for (int i = 0; i < donationCount; i++) {
            if (donations[i].getStatus().equalsIgnoreCase("available")) {
                donations[i].displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Food not available. Sorry for the inconvinience.");
        }
    }

    public void markAsCollected(String foodItem) {
        boolean found = false;
        for (int i = 0; i < donationCount; i++) {
            if (donations[i].getFoodItem().equalsIgnoreCase(foodItem) && 
                donations[i].getStatus().equalsIgnoreCase("available")) {
                donations[i].setStatus("collected");
                System.out.println("Success: Status updated to 'collected' for item: " + foodItem);
                found = true;
                break; // Updating the first available match found
            }
        }
        if (!found) {
            System.out.println("'" + foodItem + "' Not Found!");
        }
    }

    public void searchByFoodItem(String foodItem) {
        System.out.println("\n--- Search Results for: " + foodItem + " ---");
        boolean found = false;
        for (int i = 0; i < donationCount; i++) {
            if (donations[i].getFoodItem().equalsIgnoreCase(foodItem)) {
                donations[i].displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("'" + foodItem + "' Not Found!");
        }
    }

    public void displayTotalFoodSaved() {
        double totalKg = 0;
        for (int i = 0; i < donationCount; i++) {
            totalKg += donations[i].getQuantityKg();
        }
        System.out.printf("%nTotal food waste prevented: %.2f kg%n", totalKg);
    }
}

public class Main {
    public static void main(String[] args) {
        DonationManager manager = new DonationManager();
        Scanner scanner = new Scanner(System.in);
        
        manager.addDonation("Shantala Patil", "Rice", 12.5);
        manager.addDonation("Vaidehi Nakate", "Dal", 8.0);
        manager.addDonation("Purva Takalkar", "Roti", 5.0);

        while (true) {
            System.out.println("     SURPLUS FOOD DONATION TRACKER      ");
            System.out.println("1. Add a New Donation");
            System.out.println("2. View Available Donations");
            System.out.println("3. Mark Donation as Collected");
            System.out.println("4. Search Donations by Food Item");
            System.out.println("5. View Total Food Saved (kg)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Donor Name: ");
                    String donorName = scanner.nextLine();
                    System.out.print("Enter Food Item Name: ");
                    String foodItem = scanner.nextLine();
                    System.out.print("Enter Quantity (in kg): ");
                    double quantityKg = scanner.nextDouble();
                    
                    manager.addDonation(donorName, foodItem, quantityKg);
                    break;
                    
                case 2:
                    manager.displayAvailableDonations();
                    break;
                    
                case 3:
                    System.out.print("Enter the Food Item name to mark as collected: ");
                    String collectedItem = scanner.nextLine();
                    manager.markAsCollected(collectedItem);
                    break;
                    
                case 4:
                    System.out.print("Enter Food Item name to search: ");
                    String searchItem = scanner.nextLine();
                    manager.searchByFoodItem(searchItem);
                    break;
                    
                case 5:
                    manager.displayTotalFoodSaved();
                    break;
                    
                case 6:
                    System.out.println("Exiting System. Thank you for saving food!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice! Please choose a number between 1 and 6.");
            }
        }
    }
}

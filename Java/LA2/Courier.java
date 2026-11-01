package LA2; 

import java.util.Scanner; 

interface DocumentDeliveries { 
    double calculateDocumentCost(); 
} 

interface ParcelDeliveries { 
    double calculateParcelCost(); 
} 

class Shipment { 
    public String trackingID; 
    public String source; 
    public String destination; 
    public float weight; 

    public Shipment(String trackingID, String source, String destination, float weight) { 
        this.trackingID = trackingID; 
        this.source = source; 
        this.destination = destination; 
        this.weight = weight; 
    } 

    public void displayShipmentDetails() { 
        System.out.println("Tracking ID : " + trackingID); 
        System.out.println("Route       : " + source + " -> " + destination); 
        System.out.println("Weight      : " + weight + " kg"); 
    } 
} 

public class Courier extends Shipment implements DocumentDeliveries, ParcelDeliveries { 
    public Courier(String trackingID, String source, String destination, float weight) { 
        super(trackingID, source, destination, weight); 
    } 

    @Override 
    public double calculateDocumentCost() { 
        if (weight <= 2) { 
            return 5.0; 
        } else { 
            return 5.0 + ((weight - 2) * 2.0); 
        } 
    } 

    @Override 
    public double calculateParcelCost() { 
        return (weight * 4.5) + 10.0; 
    } 

    public static void main(String[] args) { 
        System.out.println("----Welcome to the CourierParcelDelivery Company----\n"); 
        Scanner sc = new Scanner(System.in); 
        
        System.out.print("Number of parcel/courier you want to send: "); 
        int number = sc.nextInt(); 
        sc.nextLine(); 
        
        for (int i = 0; i < number; i++) { 
            System.out.println("\n--- Entering details for Shipment #" + (i + 1) + " ---");
            System.out.print("Is it a Courier or Parcel (Enter C for Courier, P for Parcel): "); 
            String choice = sc.nextLine().trim(); 
            
            System.out.print("Enter your tracking ID (eg. TRACK101): "); 
            String trackingID = sc.nextLine(); 
            
            System.out.print("Enter Source: "); 
            String source = sc.nextLine(); 
            
            System.out.print("Enter Destination: "); 
            String destination = sc.nextLine(); 
            
            System.out.print("Enter Weight of the parcel/courier (kg): "); 
            float weight = sc.nextFloat(); 
            sc.nextLine(); 
            
            if (choice.equalsIgnoreCase("C")) { 
                System.out.println("\nProcessing Courier Delivery..."); 
                Courier docShipment = new Courier(trackingID, source, destination, weight); 
                docShipment.displayShipmentDetails(); 
                System.out.printf("Total Document Delivery Cost: $%.2f\n", docShipment.calculateDocumentCost()); 
            } else if (choice.equalsIgnoreCase("P")) { 
                System.out.println("\nProcessing Parcel Delivery..."); 
                Courier parcelShipment = new Courier(trackingID, source, destination, weight); 
                parcelShipment.displayShipmentDetails(); 
                System.out.printf("Total Parcel Delivery Cost: $%.2f\n", parcelShipment.calculateParcelCost()); 
            } else {
                System.out.println("\nInvalid Choice! Skipping this entry.");
            }
        } 
        sc.close(); 
    } 
}

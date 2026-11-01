/*•	Display the total kg of food saved
2.	Campus Electricity Usage Calculator
Scenario: The college wants to know how much electricity each classroom or lab uses so it can identify rooms that waste power.
Problem: Create a Room class with room name, number of lights, number of fans, and hours used per day. Create an Appliance-related method inside Room that calculates daily units consumed (for example, 40 W per light and 75 W per fan).
Tasks:
3.	Accept details of n rooms using an array of Room objects
4.	Calculate daily and monthly consumption for each room
5.	Find the room with the highest consumption
6.	Flag rooms above a set limit as "High usage"
7.	Suggest savings if usage hours are reduced by 1 hour per day
*/
package assignment6;
import java.util.Scanner;

class Room {
    private String roomName;
    private int numLights;
    private int numFans;
    private double hoursUsedPerDay;

    private static final double LIGHT_WATTAGE = 40.0; //unit Watt
    private static final double FAN_WATTAGE = 75.0; //unit Watt

    public Room(String roomName, int numLights, int numFans, double hoursUsedPerDay) {
        this.roomName = roomName;
        this.numLights = numLights;
        this.numFans = numFans;
        this.hoursUsedPerDay = hoursUsedPerDay;
    }

    public String getRoomName() {
        return roomName;
    }

    public double calculateDailyUnits() {
        double totalPowerWatts = (numLights * LIGHT_WATTAGE) + (numFans * FAN_WATTAGE);
        // Energy (kWh) = (Power in Watts * Time in Hours) / 1000
        return (totalPowerWatts * hoursUsedPerDay) / 1000.0;
    }

    public double calculateMonthlyUnits() {
        return calculateDailyUnits() * 30.0;//number of days 30
    }

    public double calculateSavingsIfReducedBy1Hour() {
        if (hoursUsedPerDay <= 0) return 0.0;
        
        double reducedHours = hoursUsedPerDay - 1.0;
        if (reducedHours < 0) reducedHours = 0.0; 

        double currentDaily = calculateDailyUnits();
        double totalPowerWatts = (numLights * LIGHT_WATTAGE) + (numFans * FAN_WATTAGE);
        double newDaily = (totalPowerWatts * reducedHours) / 1000.0;

        return (currentDaily - newDaily) * 30.0; // Monthly savings in units
    }

    public void displayRoomReport(double highUsageLimitMonthly) {
        double dailyUnits = calculateDailyUnits();
        double monthlyUnits = calculateMonthlyUnits();

        String status = (monthlyUnits > highUsageLimitMonthly) ? " HIGH USAGE" : " Normal";

        System.out.printf("Room: %-15s | Daily: %-6.2f units | Monthly: %-7.2f units | Status: %s%n", 
                roomName, dailyUnits, monthlyUnits, status);
    }
}

public class Campus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rooms (n): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        Room[] campusRooms = new Room[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Room #" + (i + 1) + ":");
            System.out.print("Enter Room Name/Number (e.g., Lab 101, Class 202): ");
            String name = scanner.nextLine();
            
            System.out.print("Enter number of lights: ");
            int lights = scanner.nextInt();
            
            System.out.print("Enter number of fans: ");
            int fans = scanner.nextInt();
            
            System.out.print("Enter average hours used per day: ");
            double hours = scanner.nextDouble();
            scanner.nextLine(); // Clear the buffer

            campusRooms[i] = new Room(name, lights, fans, hours);
        }

        System.out.print("\nEnter the monthly high-usage limit threshold (in Units): ");
        double limitThreshold = scanner.nextDouble();

        System.out.println("                     CAMPUS ELECTRICITY USAGE REPORT                 ");
        for (Room room : campusRooms) {
            room.displayRoomReport(limitThreshold);
        }
        Room highestConsumingRoom = campusRooms[0];
        for (int i = 1; i < campusRooms.length; i++) {
            if (campusRooms[i].calculateMonthlyUnits() > highestConsumingRoom.calculateMonthlyUnits()) {
                highestConsumingRoom = campusRooms[i];
            }
        }
        
        System.out.println("\n [CRITICAL INSIGHT]");
        System.out.printf("Highest Power Consumer: Room '%s' (Consuming %.2f units/month)%n", 
                highestConsumingRoom.getRoomName(), highestConsumingRoom.calculateMonthlyUnits());

        System.out.println("\n [ECO-SAVINGS RECOMMENDATIONS]");
        System.out.println("Potential monthly savings if usage is reduced by 1 hour/day across rooms:");
        double totalPotentialSavings = 0;
        
        for (Room room : campusRooms) {
            double monthlySavings = room.calculateSavingsIfReducedBy1Hour();
            totalPotentialSavings += monthlySavings;
            System.out.printf(" - Room %-12s : Can save %6.2f units/month%n", room.getRoomName(), monthlySavings);
        }
        System.out.printf("%n Total Potential Campus Savings: %.2f units per month!%n", totalPotentialSavings);

        scanner.close();
    }
}


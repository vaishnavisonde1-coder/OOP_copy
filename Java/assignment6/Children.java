/*Village Vaccination Record Keeper
Scenario: A rural health center keeps vaccination records in paper registers. Records get lost, and workers cannot easily tell which children are still due for a vaccine.
Problem: Create a Child class with name, age in months, village, and number of doses received (out of a required total, say 5). Create a HealthCenter class holding an array of Child objects.
Tasks:
•	Register a new child
•	Record a vaccine dose (method increments the dose count and blocks going above the maximum)
•	Display children who have incomplete vaccination (defaulters)
•	Display village-wise count of fully vaccinated children
•	Calculate overall vaccination coverage as a percentage
 */
package assignment6;
import java.util.HashMap;
import java.util.Map;

class Child {
    private String name;
    private int ageInMonths;
    private String village;
    private int dosesReceived;
    public static final int MAX_DOSES = 5;

    public Child(String name, int ageInMonths, String village, int dosesReceived) {
        this.name = name;
        this.ageInMonths = ageInMonths;
        this.village = village;
        // Cap initial doses at MAX_DOSES
        this.dosesReceived = Math.min(dosesReceived, MAX_DOSES);
    }

    // Method to record a dose and block exceeding the maximum
    public boolean recordDose() {
        if (dosesReceived < MAX_DOSES) {
            dosesReceived++;
            System.out.println("Dose recorded for " + name + ". Total doses: " + dosesReceived + "/" + MAX_DOSES);
            return true;
        } else {
            System.out.println("Vaccination already complete for " + name + " (" + MAX_DOSES + "/" + MAX_DOSES + " doses).");
            return false;
        }
    }

    public boolean isFullyVaccinated() {
        return dosesReceived == MAX_DOSES;
    }

    // Getters
    public String getName() { return name; }
    public int getAgeInMonths() { return ageInMonths; }
    public String getVillage() { return village; }
    public int getDosesReceived() { return dosesReceived; }

    @Override
    public String toString() {
        return String.format("Name: %-12s | Age: %2d months | Village: %-10s | Doses: %d/%d", 
                             name, ageInMonths, village, dosesReceived, MAX_DOSES);
    }
}

class HealthCenter {
    private Child[] children;
    private int childCount;

    public HealthCenter(int capacity) {
        children = new Child[capacity];
        childCount = 0;
    }

    public boolean registerChild(String name, int ageInMonths, String village, int dosesReceived) {
        if (childCount < children.length) {
            children[childCount] = new Child(name, ageInMonths, village, dosesReceived);
            childCount++;
            System.out.println("Child registered successfully: " + name);
            return true;
        } else {
            System.out.println("Health Center records are full. Cannot register " + name);
            return false;
        }
    }

    public void recordVaccineDose(String childName) {
        for (int i = 0; i < childCount; i++) {
            if (children[i].getName().equalsIgnoreCase(childName)) {
                children[i].recordDose();
                return;
            }
        }
        System.out.println("Child with name '" + childName + "' not found.");
    }

    // Task 3: Display children with incomplete vaccination (defaulters)
    public void displayDefaulters() {
        System.out.println("\n--- LIST OF DEFAULTERS (Incomplete Vaccination) ---");
        boolean foundDefaulter = false;
        for (int i = 0; i < childCount; i++) {
            if (!children[i].isFullyVaccinated()) {
                System.out.println(children[i]);
                foundDefaulter = true;
            }
        }
        if (!foundDefaulter) {
            System.out.println("No defaulters found! All registered children are fully vaccinated.");
        }
    }

    // Task 4: Display village-wise count of fully vaccinated children
    public void displayVillageWiseFullyVaccinatedCount() {
        System.out.println("\n--- VILLAGE-WISE FULLY VACCINATED COUNT ---");
        Map<String, Integer> villageCounts = new HashMap<>();

        for (int i = 0; i < childCount; i++) {
            String village = children[i].getVillage();
            villageCounts.putIfAbsent(village, 0);

            if (children[i].isFullyVaccinated()) {
                villageCounts.put(village, villageCounts.get(village) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : villageCounts.entrySet()) {
            System.out.println("Village: " + entry.getKey() + " | Fully Vaccinated: " + entry.getValue());
        }
    }

    // Task 5: Calculate overall vaccination coverage as a percentage
    public double calculateOverallCoveragePercentage() {
        if (childCount == 0) return 0.0;

        int fullyVaccinatedCount = 0;
        for (int i = 0; i < childCount; i++) {
            if (children[i].isFullyVaccinated()) {
                fullyVaccinatedCount++;
            }
        }
        return ((double) fullyVaccinatedCount / childCount) * 100;
    }
}

public class Children {
    public static void main(String[] args) {
        HealthCenter center = new HealthCenter(10);

        System.out.println("--- REGISTERING CHILDREN ---");
        center.registerChild("Vaishnavi", 12, "Rampur", 3);
        center.registerChild("Snehal", 24, "Rampur", 5);
        center.registerChild("Shantala", 8,  "Shyampur", 3);
        center.registerChild("Purva",  18, "Shyampur", 5);
        center.registerChild("Vaidehi", 15, "Chandpur", 4);

        System.out.println("\n--- RECORDING VACCINE DOSES ---");
        center.recordVaccineDose("Shantala"); // 3 -> 4
        center.recordVaccineDose("Purva"); // Already 5 (Blocked)

        center.displayDefaulters();

        center.displayVillageWiseFullyVaccinatedCount();

        double coverage = center.calculateOverallCoveragePercentage();
        System.out.println("\n--- OVERALL COVERAGE ---");
        System.out.printf("Overall Vaccination Coverage: %.2f%%\n", coverage);
    }
}
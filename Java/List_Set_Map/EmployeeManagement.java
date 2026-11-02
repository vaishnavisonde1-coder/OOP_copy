package List_Set_Map;
import java.util.HashMap;
import java.util.Map;

public class EmployeeManagement {
    public static void main(String[] args) {

        Map<Integer, String> employeeMap = new HashMap<>();

        employeeMap.put(101, "Shantala Patil");
        employeeMap.put(102, "Snehal Mote");
        employeeMap.put(103, "Purva Takalkar");
        employeeMap.put(104, "Vaidehi Nakate");

        System.out.println("Initial Employee Records: " + employeeMap);

        int searchId = 102;
        System.out.println("Employee with ID " + searchId + ": " + employeeMap.get(searchId));

        System.out.println("Does ID 105 exist? " + employeeMap.containsKey(105));
        System.out.println("Does ID 103 exist? " + employeeMap.containsKey(103));
        if(employeeMap.containsKey(103)){
            System.out.println("Employee Name: " + employeeMap.get(103)+"\n");
        }
        System.out.println("Does employee 'Vaishnavi Sonde' exist? " + employeeMap.containsValue("Vaishnavi Sonde"));
        System.out.println("Does employee 'Snehal Mote' exist? " + employeeMap.containsValue("Snehal Mote"));

        employeeMap.put(102, "Rohini Bhavar");
        System.out.println("After updating ID 102: " + employeeMap);

        employeeMap.remove(104);
        System.out.println("After removing ID 104: " + employeeMap);

        System.out.println("\n Displaying using different Map views");
        System.out.println("All Employee IDs (keySet): " + employeeMap.keySet());
        System.out.println("All Employee Names (values): " + employeeMap.values());
        System.out.println("All Records (entrySet):");
        for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " | Name: " + entry.getValue());
        }
    }
}

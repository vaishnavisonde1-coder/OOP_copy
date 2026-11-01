package assignment9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentListManagement {
    public static void main(String[] args) {
        List<String> students = new ArrayList<>();

        students.add("Vaidehi");
        students.add("Purva");
        students.add("Shantala");
        students.add("Snehal");

        System.out.println("Initial Student List: " + students);

        students.add(2, "Rohini"); 
        System.out.println("After inserting Rohini at index 2: " + students);

        students.set(4, "Mansi");
        System.out.println("After updating index 4 to Mansi: " + students);

        students.remove("Purva"); 
        students.remove(0);     
        System.out.println("After removing Purva and student at index 0: " + students);

        String searchName = "Vaidehi";
        if (students.contains(searchName)) {
            System.out.println(searchName + " is present in the list.");
        } else {
            System.out.println(searchName + " is not present in the list.");
        }
         searchName = "Rohini";
        if (students.contains(searchName)) {
            System.out.println(searchName + " is present in the list.");
        } else {
            System.out.println(searchName + " is not present in the list.");
        }

        Collections.sort(students);
        System.out.println("Alphabetically Sorted Student List: " + students);
        System.out.println("Total number of students: " + students.size());
        System.out.println("Student at index 1: " + students.get(1));
    }
}

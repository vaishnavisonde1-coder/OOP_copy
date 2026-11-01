package assignment9;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<String> bookTitles = new ArrayList<>();
        Set<String> bookIsbns = new HashSet<>();
        Map<String, String> bookMap = new HashMap<>();

        bookTitles.add("Sane Guruji");
        bookTitles.add("C++ Programming");
        bookTitles.add("Harry Potter");
        bookTitles.add("Sane Guruji");
        System.out.println("Book Titles in ArrayList (Insertion Order): " + bookTitles);

        bookIsbns.add("978-0134685991");
        bookIsbns.add("978-0132350884");
        bookIsbns.add("978-0596009205");
        bookIsbns.add("978-0134685991"); 
        System.out.println("Unique ISBNs in HashSet: " + bookIsbns);

        bookMap.put("978-0134685991", "Sane Guruji");
        bookMap.put("978-0132350884", "C++ Programming");
        bookMap.put("978-0596009205", "Harry Potter");

        String searchIsbn = "978-0132350884";
        if (bookMap.containsKey(searchIsbn)) {
            System.out.println("\nBook found for ISBN " + searchIsbn + ": " + bookMap.get(searchIsbn));
        }

        bookMap.put("978-0134685991", "Sane Guruji(3rd Edition)");
        System.out.println("After updating ISBN 978-0134685991: " + bookMap.get("978-0134685991"));

        String removeIsbn = "978-0596009205"; 
        String removedTitle = bookMap.remove(removeIsbn);
        bookIsbns.remove(removeIsbn);
        bookTitles.remove(removedTitle);
        System.out.println("Removed: " + removedTitle);

        System.out.println("\nCurrent Library Records (Iterating Map EntrySet)");
        for (Map.Entry<String, String> record : bookMap.entrySet()) {
            System.out.println("ISBN: " + record.getKey() + " -> Title: " + record.getValue());
        }

        System.out.println("\n--- Collection Sizes ---");
        System.out.println("Total titles in ArrayList: " + bookTitles.size());
        System.out.println("Total unique ISBNs in HashSet: " + bookIsbns.size());
        System.out.println("Total mappings in HashMap: " + bookMap.size());
    }
}

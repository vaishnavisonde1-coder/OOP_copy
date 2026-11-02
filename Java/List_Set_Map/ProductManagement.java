package List_Set_Map;
import java.util.HashSet;
import java.util.Set;

public class ProductManagement {
    public static void main(String[] args) {
        
        Set<String> products = new HashSet<>();

        products.add("Robot");
        products.add("SSD");
        products.add("HDD");
        products.add("SSD");
        products.add("Compact Disks");
        System.out.println("Initial product list: "+ products);
        String added = "SSD";
        boolean isAddedAgain = products.add(added);
        System.out.println("Was duplicate "+added+" added successfully? " + isAddedAgain);

        System.out.println("Unique Product List: " + products);

        String targetProduct = "Robot";
        System.out.println("Does " + targetProduct + " exist? " + products.contains(targetProduct));

        products.remove("Compact Disks");
        System.out.println("After removing Compact Disks: " + products);

        System.out.println("Total number of unique products: " + products.size());

        products.clear();
        System.out.println("After using .clear, is the product set empty? " + products.isEmpty());
        System.out.println("Final product list size: " + products.size());
    }
}

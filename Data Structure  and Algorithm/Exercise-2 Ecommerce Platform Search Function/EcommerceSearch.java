import java.util.Arrays;
import java.util.Comparator;

public class EcommerceSearch {

    public static Product linearSearch(Product[] products, int targetId) {
        for(Product p:products) {
            if(p.productId == targetId) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] sortedProducts, int targetId) {
        int low = 0;
        int high = sortedProducts.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(sortedProducts[mid].productId == targetId) {
                return sortedProducts[mid];
            } else if(sortedProducts[mid].productId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Footwear"),
            new Product(110, "Phone", "Electronics"),
            new Product(101, "Watch", "Accessories"),
            new Product(108, "Backpack", "Bags")
        };

        Product result1 = linearSearch(products, 110);
        System.out.println("Linear Search Result: " + (result1 != null ? result1.productName : "Not found"));
        

        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts, Comparator.comparingInt(p -> p.productId));

        Product result2 = binarySearch(sortedProducts, 110);
        System.out.println("Binary Search Result: " + (result2 != null ? result2.productName : "Not found"));

        
        
    }

    
}

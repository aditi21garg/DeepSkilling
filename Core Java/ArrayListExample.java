import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        System.out.print("How many names do you want to add? ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            String name = scanner.next();
            names.add(name);
        }

        System.out.println("Names entered:");
        for (String name : names) {
            System.out.println(name);
        }

        scanner.close();
    }
}
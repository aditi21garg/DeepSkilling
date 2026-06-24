// package DESIGN PATTERN AND PRINCIPLE.Exercise-1 Implementing the Singleton Pattern;

// public class SingletonTest {
    
// }
public class SingletonPattern {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        if (logger1 == logger2) {
            System.out.println("Both objects are same. Singleton works!");
        } else {
            System.out.println("Singleton failed!");
        }
    }
}

public class TypeCastingExample {
    public static void main(String[] args) {
        
        double myDouble = 9.78;
        int doubleToInt = (int) myDouble;
        System.out.println("Double value:" + myDouble);
        System.out.println("Double cast to int" + doubleToInt);

        int myInt = 15;
        double intToDouble = (double) myInt;
        System.out.println("Int value:" + myInt);
        System.out.println("Int cast to double" + intToDouble);
    }
    
}

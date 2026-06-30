public class PatternMatchingSwitch {

    public static void checkType(Object obj) {
        String result = switch (obj) {
            case Integer i -> "This is an Integer: " + i;
            case String s -> "This is a String: " + s;
            case Double d -> "This is a Double: " + d;
            case null -> "This is null";
            default -> "Unknown type";
        };
        System.out.println(result);
    }

    public static void main(String[] args) {
        checkType(42);
        checkType("Hello");
        checkType(3.14);
        checkType(true);
    }
}
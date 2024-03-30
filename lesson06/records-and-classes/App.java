import java.util.ArrayList;
import java.util.List;


record Person (String name, String address) {}
public class App {
    public static void main(String[] args) {
    }

    public static void foo(Object o) {
        Object o1 = o;


    }

    public static Integer incSeven(Integer nr) {
        /**
         * Unboxing nr to add 7 => e.g. nr.intValue();
         * Boxing the final result to Integer => Integer.valueOf(...)
         */
        return Integer.valueOf(nr.intValue() + 7);
    }
}
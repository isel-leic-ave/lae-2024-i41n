public class App {
    public static void main(String[] args) {
        String s = new String("I'm a non football fan");
        String s1 = s;
        s = "ABC";
        s1 = null;



        int a = 7;
        Object o1 = Integer.valueOf(a);

        int x1 = ((Integer)o1).intValue();

        long b = 11;
        float c = 9.3f;
        double d = 3.4;
        foo(a); // invokestatic Integer.valueOf(int): Integer
        foo(b); // invokestatic Long.valueOf(long): Long
        foo(c); // invokestatic Float.valueOf(float): Float
        foo(d); // invokestatic Double.valueOf(double): Double
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
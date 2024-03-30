final public class B2 {
    public final static B2 INSTANCE;

    static {
        INSTANCE = new B2();
    }

    private B2() {
    }

    public void foo() {
        System.out.println("I am B");
    }
}

class App1 {
    public static void main(String[] args) {
        B2.INSTANCE.foo();

    }
}

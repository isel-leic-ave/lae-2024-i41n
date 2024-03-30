public final class B1 {
    private B1() { }

    public final static B1 INSTANCE;

    static {
        INSTANCE = new B1();
    }


    public void foo() {
        System.out.println("I am B1");
    }
}
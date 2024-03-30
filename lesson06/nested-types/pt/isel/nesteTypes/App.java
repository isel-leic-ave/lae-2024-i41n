package pt.isel.nesteTypes;

import static java.lang.System.out;

public class App {
    public static void main(String[] args) {
        Outer o1 = new Outer();
        Outer o2 = new Outer();


        o1.m1();
        o2.m1();

        new A(7).makeB().foo();
        new A(11).makeB().foo();

        Outer.Nested nested = new Outer.Nested();
        Outer.Inner inner1 = o1.new Inner(2);
        Outer.Inner inner2 = o1.new Inner(3);

        inner1.m1();
        inner2.m1();

    }
}


class Outer {
    private static int classField = 10;

    private int instanceField = 20;

    void m1() {
        this.instanceField = 21;  // instanceField = 21
        this.classField = 11;    // classField = 21
    }




    static void m2() {
        classField = 12;
    }

    /**
     * Additional FIELD this$0 because it is non-static.
     */
    public class Inner {
        int x;
        public Inner(int x) {
            this.x = x;
        }
        void m1() {
            Outer.classField = 11;
            x = 10;
            instanceField = 12;
        }
    }

    public static class Nested {
        void m1() {
            Outer.classField = 11;
        }

    }
}

/**
 * Members:
 * - FIELD nr
 * - constructor A(), i.e. <init>
 * - METHOD makeB()
 */
class A {
    private final int nr;

    public A(int nr) {
        this.nr = nr;
    }
    public B makeB() {
        // <=> new B(this)
        return new B();
    }
    /**
     * MEMBERS:
     * - METHOD foo
     * - FIELD this$0
     * - constructor A$B(A), i.e. <init>(A):
     *   > initializes field this$0 with the value of the parameter.
     *  
     */
    class B {
        public void foo() {
            // <=> out.println(A.this.nr);
            // A.this <=> FIELD this$0
            // 
            out.println(nr); // Inner class accessing field from outer class
        }
    }

}
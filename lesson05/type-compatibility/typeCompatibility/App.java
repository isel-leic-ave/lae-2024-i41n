package typeCompatibility;

import java.util.ArrayList;
import java.util.List;

interface I1 {
    void mi1();
    void mi2();
}

interface I2 {
    void mi3();
    void mi4();
}



abstract class A implements I1, I2 {
    abstract void m1();
    abstract void m2();
}

abstract class B extends A  {
    void m3() {  }

    void m1() {
        System.out.println("m1 implemented in B");
    }

    @Override
    void m2() {
        System.out.println("m2 implemented in B");
    }


    @Override
    public void mi3() {

    }

    @Override
    public void mi4() {

    }
}


class C extends A {

    @Override
    void m1() {
        System.out.println("m1 implemented in C");
    }


    @Override
    void m2() {
        System.out.println("m2 implemented in C");
    }

    @Override
    public void mi1() {

    }

    @Override
    public void mi2() {

    }

    @Override
    public void mi3() {

    }

    @Override
    public void mi4() {

    }
}

class D extends C {

}


class E extends Object {

}

public class App {
    public static void main(String[] args) {
        String s = new String("I'm a non football fan");
        String s1 = s;
        s = new String("ABC");
        s1 = null;
        Object o = s;

        A a1 = new C();
        A a2 = new D();

        useAs(a1);
        useAs(a2);

        a1.m1();
        a2.m1();

        a1.m2();
        a2.m2();

        a1 = a2;
        a1.m1();
    }


    static void useAs(A a) {
        a.m1();
    }

}
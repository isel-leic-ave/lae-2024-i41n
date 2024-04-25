package pt.isel;

import org.cojen.maker.ClassMaker;
import org.cojen.maker.MethodMaker;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class CojenMakerTest {

    public static ClassMaker introCojenMaker()  {
        ClassMaker cm = ClassMaker.begin("Xpto").public_();
        cm.addConstructor().public_();

        MethodMaker mm = cm.addMethod(null, "run").public_();

        // <=> System.out.println("hello, world")
        mm.var(System.class).field("out").invoke("println", "hello, world");

        return cm;
    }


    public static void main(String[] args) throws Exception {
        ClassMaker cm = introCojenMaker();

//        cm.finishTo(new FileOutputStream(cm.name() + ".class"));
        Class<?> newClass  = cm.finish();
        Object obj = newClass.getDeclaredConstructor().newInstance();
        System.out.println(obj.toString());

        newClass.getMethod("run").invoke(obj);
    }

}

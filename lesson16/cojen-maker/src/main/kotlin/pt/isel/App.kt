package pt.isel

import org.cojen.maker.ClassMaker
import org.cojen.maker.MethodMaker
import org.cojen.maker.Variable
import java.io.FileOutputStream
import java.lang.reflect.Method
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.memberFunctions



class Student(val name: String, val nr: Int) : Any()

fun main() {
    //switchJavaKotlinReflect(Student("Maria", 73641))

//    val cm = introCojenMaker()
//    val newClass: Class<*> = cm.finish();
//
//    //newClass.kotlin.createInstance()
//
//    val obj: Any = newClass.getDeclaredConstructor().newInstance()
//    val m: Method = newClass.getDeclaredMethod("run")
//    m.invoke(null)



//
//
//    cm.finishTo(FileOutputStream(cm.name() + ".class"))
//    val klass: Class<*> = cm.finish()
//    klass.kotlin.createInstance() // ERROR There is no-arg constructor

    val cm: ClassMaker = dynamicClass()
    cm.finishTo(FileOutputStream(cm.name() + ".class"))
//    val klass: Class<*> = cm.finish()
//    val receiver = klass
//        .kotlin
//        .constructors
//        .first()
//        .call(9)
//
//    val res = klass
//        .kotlin
//        .memberFunctions
//        .first { it.name == "mul" }
//        .call(receiver, 3)
//    println(res)
}

fun switchJavaKotlinReflect(obj: Any) {
    println("##### Kotlin Reflect API")
    val klass: KClass<*> = obj::class
    klass.members.forEach { println("member: ${it.name}-${it::class}") }
    println("#### Java Reflect API")
    klass.java.methods.forEach { println(it.name) }
    println("##### Kotlin Reflect API")
    klass.java.kotlin.members.forEach { println(it.name) }
}

fun introCojenMaker(): ClassMaker {
    val cm = ClassMaker.begin("Xpto").public_()


    cm.addConstructor().public_()
    val mm = cm.addMethod(null, "run").public_().static_()


    // <=> System.out.println("hello, world")
    mm.`var`(System::class.java).field("out").invoke("println", "hello, world")

    return cm
}

/**
 * Generate something similar to:
 *
public class Dummy {
private final int nr;
public Dummy(int nr) {
this.nr = nr;
}
public int mul(int other) {
return this.nr * other;
}
}
 */


fun dynamicClass(): ClassMaker {
    val cm = ClassMaker.begin("Dummy").public_()
    val fieldNr = cm
        .addField(Int::class.java, "nr")
        .private_()
        .final_()
    val init = cm
        .addConstructor(Int::class.java)
        .public_()
    init.invokeSuperConstructor()
    init
        .field(fieldNr.name())
        .set(init.param(0))
    val methodMul = cm
        .addMethod(Int::class.java, "mul", Int::class.java)
        .public_()
    val res: Variable = methodMul
        .field(fieldNr.name())
        .mul(methodMul.param(0))
    methodMul.return_(res)
    return cm
}
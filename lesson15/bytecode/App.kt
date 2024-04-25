import kotlin.math.sqrt


fun showValues() {
    println(1)
    println(2)
    println(3)
    println(4)
    println(5)
    println(6)
    println(7)
    println(8)
    println(9)
    println(10)
    println(11)
}

fun modulus(x: Float, y: Float) : Float {
    val res = sqrt(x*x + y*y)
    return res
}

fun calculateNetBalance(
    balance: Int,
    tax: Float,
    interest: Float,
    income: Int,
    expense: Float
): Float {
    return balance - balance * tax + balance * interest + income - expense
}

class Person(val name: String) {
    fun print(label: String) {
        // this is local variable 0
        val myName = this.name
        // Label is local variable 1
        println(label + ": " + myName)


        atore_2
        getstatic     System.out
        aload_2
        invokevirtual       prrintl


    }
}

class Student()

fun main() {
    val st = Student()
    println(st)


    val a1: A = getA()
    a1.m1()
}


fun getA(): A {
    return B()
}

open class A() {
    open fun m1() {
        println("m1 from A")

    }
}

class B(): A() {
    override fun m1() {
        println("m1 from B")
    }
}
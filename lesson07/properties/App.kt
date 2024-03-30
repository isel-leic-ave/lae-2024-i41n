class Person(val name: String)

class Rectangle(val width: Int, val height: Int) {
    val area = width * height
}

val x = 10;

fun main() {
    val p = Person("Maria")
    println(p.name)
    println(x)
    //p.name = "Manuela" // => p.setName("Manuela")
}
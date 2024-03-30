package pt.isel

import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties


/**
 * Represents the Property country in class Student.
 * Not the value.
 */
val propCountry = Student::class
    .memberProperties
    .first { it.name == "country" }

fun main() {

    val klass: KClass<Person> = Person::class
    val maria: Person = Person("Maria", "Portugal")

    val kclass1: KClass<*> = maria::class
    println(kclass1 === klass)

    checkProperties(maria)

    val joana: Student = Student(1234, "Joana", "Portugal")
    checkProperties(joana)
//    checkCountry(maria)
//    checkCountry(Person("Jose", "Brasil"))

}
fun checkMembers(obj: Any) {
    val klass: KClass<out Any> = obj::class
    klass.members.forEach { println(it) }
}
fun checkProperties(obj: Any) {
    val klass: KClass<*> = obj::class
    klass.memberProperties.forEach { val v = it; println(it.call(obj));  }
}


fun checkCountry(obj: Any) {
    obj::class
        .memberProperties
        .first { it.name == "country" }
        .let { prop -> println(prop.call(obj)) }
}

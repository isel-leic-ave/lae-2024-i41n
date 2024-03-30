package pt.isel

import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.memberFunctions
import kotlin.test.Test

class AnotherTest {
    @Test
    fun test3() {
        println("AnotherTest.test3")
    }

    fun m3() {
        println("AnotherTest.m3")
    }

    fun m4() {
        println("AnotherTest.m4")
    }
}

class SampleTest() {
    @Test
    fun test1() {
        println("SampleTest.test1")
    }

    fun m2(i: Int) {
        println("SampleTest.m2")
    }
}

fun main() {
    runTests(AnotherTest::class)
    runTests(SampleTest::class)
}

fun <T : Any> runTests(klass: KClass<T>) {
    val obj: T = klass.createInstance()
    klass.memberFunctions.
        filter { it.parameters.size == 1 }.
        forEach { it.call(obj) }


}
public class Account {
    fun foo() { }
    companion object {
        var countInstances = 0
        fun foo() { }
    }

    init {
        Account.countInstances++
        Companion.foo()
    }
}

fun main() {
    Account()
    Account()
    Account()
    Account()
    println(Account.countInstances)
}
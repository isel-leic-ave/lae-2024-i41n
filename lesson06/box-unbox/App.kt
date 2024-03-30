
fun incSeven(nr: Int?) : Int? {
    require(nr != null)
    val a =  nr + 7;
    val b = nr;

    return a + b;
}


fun foo(l: Int) : Int {
    return incSeven(l) ?: 0
}
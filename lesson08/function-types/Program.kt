fun main() {
//    var i : Int = 0
//    var f: (String, Char) -> Int = ::xpto
//
//    ypto(f)
//    f = zpto()

    var f1: (String, Char) -> Int = { s, c -> (s+c).length }
    f1()


//    ypto({ s, c -> (s+c).length })
//    println(f("isel", 'f'))
}

fun xpto(s: String, c: Char) : Int {
    println(s+c)
    return (s+c).length
}

fun ypto(ff: (String, Char) -> Int) {
    ff("SLB", 'A')
}

fun zpto() : (String, Char) -> Int {
    return ::xpto
}


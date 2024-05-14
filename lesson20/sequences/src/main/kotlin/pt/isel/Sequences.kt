package pt.isel


fun numbersIterable() : Iterable<String> {
    return listOf("Instituto", "Superior", "de", "Engenharia", "de", "Lisboa")
}

fun numbersSequence() : Sequence<String> {
    return sequenceOf("Instituto", "Superior", "de", "Engenharia", "de", "Lisboa")
}


fun main(args: Array<String>) {
    val numbers = numbersIterable()
    //val numbers = numbersSequence()
    var count = 0
    val seq = numbers
        .myFilterLazy { count++; it.length >3 }
        //.myMapLazy { count++; it }
        //.myTakeLazy(2)

    val iterator1 = seq.iterator()

    iterator1.hasNext()
    iterator1.hasNext()
    println(iterator1.next())
    //iterator1.hasNext()
//////    val iterator2 = seq.iterator()
//    println(iterator1.next())
//    println(iterator1.next())
//    println(iterator1.next())
//
//    println(iterator2.next())
//
//    println(iterator1.next())

        //.sum()
    //println(seq)
    println("Count incremented ${count} times." )

}
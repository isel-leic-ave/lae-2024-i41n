package pt.isel

import pt.isel.FilterIteratorState.*
import java.util.NoSuchElementException



fun <T, R> Iterable<T>.myMap( mapper: (T)->R) : Iterable<R> {
    val result = mutableListOf<R>()
    for (t in this) {
        result.add(mapper(t))
    }
    return result;
}

fun <T> Iterable<T>.myFilter(predicate: (T)->Boolean ) : Iterable<T> {
    val result = mutableListOf<T>()
    for (next in this) {
        if(predicate(next)) {
            result.add(next)
        }
    }
    return result;
}



fun <T, R> Iterable<T>.myMapLazy( mapper: (T)->R) : Iterable<R> {
    return object : Iterable<R> {
        override fun iterator(): Iterator<R> {
            val prevIterator = this@myMapLazy.iterator()
            return object : Iterator<R> {
                override fun hasNext(): Boolean {
                    return prevIterator.hasNext()
                }

                override fun next(): R {
                    return mapper(prevIterator.next())
                }
            }
        }
    }
}


fun <T> Iterable<T>.myTakeLazy(size: Int) : Iterable<T> {
    return object : Iterable<T> {
        override fun iterator(): Iterator<T> {
            val prevIterator: Iterator<T> = this@myTakeLazy.iterator()
            var count = 0
            return object: Iterator<T> {
                override fun hasNext() = count < size && prevIterator.hasNext()

                override fun next(): T {
                    if(++count > size)
                        throw NoSuchElementException()

                    return prevIterator.next()
                }
            }
        }
    }
}

fun <T> Iterable<T>.myFilterLazy( predicate: (T)->Boolean ) : Iterable<T> {
    return object : Iterable<T> {
        override fun iterator(): Iterator<T> {
            val prevIterator: Iterator<T> = this@myFilterLazy.iterator()
            var nextVal: T? = null
            return object: Iterator<T> {
                override fun hasNext(): Boolean {
                    if(nextVal != null)
                        return true
                    while (prevIterator.hasNext()) {
                        val currVal = prevIterator.next()
                        if(predicate(currVal)) {
                            nextVal = currVal
                            return true
                        }
                    }
                    return false
                }
                override fun next(): T {
                    if(nextVal == null) {
                        if(!hasNext()) throw NoSuchElementException()
                    }
                    val retVal = nextVal!!
                    nextVal = null
                    return retVal
                }
            }
        }
    }
}




fun <T, R> Iterable<T>.eagerMap(transform: (T) -> R) : Iterable<R> {
    val destination = mutableListOf<R>()
    for (item in this)
        destination.add(transform(item))
    return destination
}

fun <T> Iterable<T>.eagerFilter(predicate: (T) -> Boolean) : Iterable<T> {
    val destination = mutableListOf<T>()
    for (item in this)
        if(predicate(item))
            destination.add(item)
    return destination
}

fun <T, R> Sequence<T>.lazyMap(transform: (T) -> R) : Sequence<R> {
    return  object : Sequence<R> {
        override fun iterator(): Iterator<R> {
            return object : Iterator<R> {
                val iter = this@lazyMap.iterator()
                override fun hasNext() = iter.hasNext()
                override fun next() = transform(iter.next())
            }
        }
    }
}

enum class FilterIteratorState {NotReady, Ready, Finish}

fun <T : Any> Sequence<T>.lazyFilter(predicate: (T) -> Boolean) : Sequence<T> {
    return object : Sequence<T> {
        override fun iterator(): Iterator<T> {
            return createIterator(this@lazyFilter.iterator(), predicate)
        }
    }
}





fun <T : Any> Sequence<T>.yieldFilter(predicate: (T) -> Boolean) = sequence {
    for (item in this@yieldFilter)
        if(predicate(item))
            yield(item)
}


public fun <T: Any> Sequence<T>.lazyDistinct(): Sequence<T> {
    return object : Sequence<T> {
        override fun iterator(): Iterator<T> {
            val itemsAlreadyReturned = mutableSetOf<T>()
            return createIterator(this@lazyDistinct.iterator()) { itemsAlreadyReturned.add(it) }
        }
    }
}
public fun <T> Sequence<T>.yieldDistinct(): Sequence<T> {
    return sequence {
        val prevValues = mutableSetOf<T>()
        for (item in this@yieldDistinct)
            if(prevValues.add(item))
                yield(item)
    }
}

public fun <T> Sequence<T>.concatEager(other: Sequence<T>): Sequence<T> {
    val result = mutableListOf<T>()
    for (item in this@concatEager)
        result.add(item)
    for (item in other)
        result.add(item)
    return result.asSequence()
}

public fun <T> Sequence<T>.yieldConcat(other: Sequence<T>): Sequence<T> {
    return sequence {
        yieldAll(this@yieldConcat)
        yieldAll(other)
    }
}



private fun <T : Any> createIterator(src: Iterator<T>, pred: (T)->Boolean) : Iterator<T> {
    return object : Iterator<T> {
        var state = NotReady
        val iter = src
        lateinit var nextItem: T

        /**
         * It advances if iter hasNext() is true and if the
         * next element satisfies the predicate.
         * It only tries to advance if it is NotReady.
         * After trying to advance it will stay Ready or Finish (after reaching the last element)
         */
        private fun tryAdvance() {
            if(state == NotReady) {
                while(iter.hasNext()) {
                    val curr = iter.next()

                    //if(predicate(curr)) {
                    if(pred(curr)) {
                        nextItem = curr
                        state = Ready
                        return
                    }
                }
                state = Finish
            }
        }

        override fun hasNext(): Boolean {
            tryAdvance()
            return state == Ready
        }

        override fun next(): T {
            if(state == Finish || !hasNext()) throw NoSuchElementException()
            state = NotReady
            return nextItem
        }
    }
}



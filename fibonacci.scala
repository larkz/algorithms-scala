// Generate fibonacci sequence

import scala.collection.mutable.ArrayBuffer

// Fibonacci function
def fib(n: Int): Int = {
    if(n == 1) {return 1}
    if(n == 0) {return 0}
    return fib(n - 1) + fib(n - 2)
}

def fib2(n: Int): ArrayBuffer[Int] = {
    val t0 = System.nanoTime()

    if(n == 0) {return ArrayBuffer(0)}
    if(n == 1) {return fib2(0) ++ ArrayBuffer(1) }
    val fibPre = fib2(n-1)
    
    val t1 = System.nanoTime()
    println("Elapsed time fib2: " + (t1 - t0) + "ns")

    return fibPre ++ ArrayBuffer(fibPre(n-1) + fibPre(n-2))

}

// Fibonnaci sequence
def fibSeq(c: Int): ArrayBuffer[Int] = {
    val t0 = System.nanoTime()

    var fs = ArrayBuffer[Int]()
    for( i <- 0 to c){
        fs = fs :+ fib(i)
    }

    val t1 = System.nanoTime()
    println("Elapsed time fib1: " + (t1 - t0) + "ns")

    fs
}




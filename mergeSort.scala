// Mergesort implementation in Scala

// merge function
import scala.collection.mutable.ArrayBuffer

def merge(v1in: ArrayBuffer[Int], v2in: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    var v3 = ArrayBuffer[Int]()
    var v2 = v2in
    var v1 = v1in
    
    while( !(v1.isEmpty && v2.isEmpty) ){
        if(v1.isEmpty){
            v3 = v3 :+ v2(0)
            v2 = v2.drop(1)
        } else if (v2.isEmpty){
            v3 = v3 :+ v1(0)
            v1 = v1.drop(1)
        } else if (v1(0) > v2(0) ){
            v3 = v3 :+ v1(0)
            v1 = v1.drop(1)
        } else {
            v3 = v3 :+ v2(0)
            v2 = v2.drop(1)
        }
    }
    v3
}

// Define merge sort
def mergeSort(arr: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    val len = arr.length
    val left = arr.slice(0, len/2)
    val right = arr.slice(len/2, len)
    if(len == 1){
        return arr
    } else {
        return merge( mergeSort(left), mergeSort(right) ) 
    }
}

val a1 = ArrayBuffer[Int](1)
val a2 = ArrayBuffer[Int](1)

merge(a1, a2)

val aa = ArrayBuffer(6,3,1,5,6,2,3,78,0,3,3)

mergeSort(aa)



class heap(inputArray: Array[Double] = Array()) {
    
    var h: Array[Double] = inputArray //Array
    
    var hlen = h.length

    def getHeap(): Array[Double] = h
    private def getLeft(i: Int): Int = {2*i + 1}
    private def getRight(i: Int): Int = {2*i + 2}

    def maxHeapify(i: Int, a: Array[Double], heapSize: Int = h.length - 1): Unit = {
        
        var largest = i
        var l = getLeft(i)
        var r = getRight(i)
        val heapSize = a.length - 1
        println("heapArray: " + a.deep)
        println("heapSize: " + heapSize)
        println("current index:" + i)
        println("left index: " + l)
        println("right index: " + r)
        
        println("current value: " + a(i))
        if(l <= heapSize) {println("get left: " + a(l))}
        if(r <= heapSize) {println("get right: "+ a(r))}

        if(l <= heapSize && (a(l) > a(i)) ){
            println("left is larger: " +  a(l))
            largest = l
        }

        if(r <= heapSize && (a(r) > a(largest)) ){
            println("right is larger: " +  a(r))
            largest = r
        }
        
        println("before swap")
        println(a.deep)

        if(largest != i){
            var temp = a(i)
            println("swapping " + temp.toString + " -with- " + a(largest).toString)
            a(i) = a(largest)
            a(largest) = temp 
            println(a.deep)
            maxHeapify(largest, a);  
        }
    }

    def buildHeap(): Unit = {
        for(e <- hlen/2 to 0 by -1){
            maxHeapify(0, h, e)
        }
    }

    def insert(d: Double): Unit = {
        h = d +: h
        maxHeapify(0, h)
    }

    def removeMax(): Unit = {
        if(h.length == 1){h = Array[Double]()}
        else{
            h = h.last +: h.drop(1).dropRight(1)
            maxHeapify(0, h)
        }
        
    }

    def heapSort(){
        buildHeap()
        for(l <- (hlen - 1) to 1 by -1  ){
            val temp = h(0)
            h(0) = h(l)
            h(l) = temp
            println("current len: " + l)
            println("heapsort swap: " + h.deep)
            maxHeapify(0, h, l-1)
        }
    }
}

val b = new heap(Array(1, 3, 36, 2, 19, 25, 100, 17, 7))

b.maxHeapify(0, b.h, 8)

b.buildHeap
b.heapSort
    

    



val a = new heap()

a.insert(1)
a.insert(4)
a.insert(5)

a.removeMax
a.removeMax



a.h = Array(1, 3, 36, 2, 19, 25, 100, 17, 7)



a.maxHeapify(0, a.h)



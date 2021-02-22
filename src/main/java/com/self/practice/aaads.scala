package com.self.practice

//remove if not needed

object QuickSort {

  /* A utility function to print array of size n */

  def printArray(arr: Array[Int]): Unit = {
    val n: Int = arr.length
    for (i <- 0 until n) System.out.print(arr(i) + " ")
    println()
  }

  // Driver program
  def main(args: Array[String]): Unit = {
    val arr: Array[Int] = Array(10, 7, 8, 9, 1, 5)
    val n: Int = arr.length
    val ob: QuickSort = new QuickSort()
//    ob.sort(arr, 0, n - 1)
//    println("sorted array")
//    printArray(arr)
    val a = Array(1,4,7,32,6,5,9)
    val b = Array(2,4,12,7,5)
    for(x <- a){
      if(!b.contains(x)){
//        println(x)
      }
    }
    val re = "abcnh"
    val er = "hncsa"
    val qa = for(x <- 0 to re.length-1) yield { re(x) match {
      case y if re(x) == er(re.length - x - 1) => true
      case _ => false
    }}
//    println(qa.reduce(_&&_))
    val p =  "geeks quiz practice code"
    val parr = p.split(" ")
    val q = (for(i <- parr.length - 1 to 0 by -1) yield parr(i))
    println(q.mkString(" "))
  }

}

class QuickSort {

  /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */

  def partitioningFunc(arr: Array[Int], low: Int, high: Int): Int = {
    val pivot: Int = arr(high)
    var i: Int = (low - 1)
    for (j <- low until high if arr(j) < pivot) {
      { i += 1; i - 1 }
      val temp: Int = arr(i)
      arr(i) = arr(j)
      arr(j) = temp
    }
    val temp: Int = arr(i + 1)
    arr(i + 1) = arr(high)
    arr(high) = temp
    i + 1
  }


  def sort(arr: Array[Int], low: Int, high: Int): Unit = {
    if (low < high) {

      val pi: Int = partitioningFunc(arr, low, high)
      sort(arr, low, pi - 1)
      sort(arr, pi + 1, high)
    }
  }

}


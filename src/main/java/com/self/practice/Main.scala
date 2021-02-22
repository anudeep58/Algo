package com.self.practice

// To execute Scala code, please define an object named Main that extends App
/*
input -> array of Integer 0, 1, 2 (duplicates)
sort the array


example:
input -> [2,0,2,1,1,0]
after call the method => [0,0,1,1,2,2]
*/

object Main extends App {
  System.out.println("Hello World!");
  val arr= Array(2,0,2,1,1,0)

//  sort(arr,0,arr.length-1)
   val ap = "anuddddeepp"
  ap.toCharArray
  def partitioningFunc(arr: Array[Int], low: Int, high: Int) ={
    val pivot = arr(high)
    var i = low-1
    for(j <- low until high){
      if(arr(j) < pivot){
        i =i+1
      }
      val temp = arr(i)
      arr(i) = arr(j)
      arr(j) = temp
    }
    //swap arr[i+1] with ar(high)
    val temp = arr(i+1)
    arr(i+1) = arr(high)
    arr(high) = temp

    i+1
  }


  def sort(arr: Array[Int], low: Int, high: Int): Unit = {
    if (low < high) {
      /* pi is partitioning index, arr[pi] is
              now at right place */

//      val pi: Int = partition(arr, low, high)
      // partition and after partition
//      sort(arr, low, pi - 1)
//      sort(arr, pi + 1, high)
    }
  }
}

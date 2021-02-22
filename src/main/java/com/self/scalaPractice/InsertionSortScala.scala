package com.self.scalaPractice

object InsertionSortScala extends App {

  def insertion(arr: Array[Int]) ={
    for(i <- 0 to arr.length-1){
      var key = arr(i)
      var j = i-1
      while(j>0 && key< arr(j)){
        arr(j) = key
        j = j-1
      }
    }
  }

  val arr = Array(1, 2, 2, 62, 23, 42, 76, 9, 7, 48)
  insertion(arr)

}

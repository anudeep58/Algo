package com.self.Jul2023

object selectionSort {
   def sort(arr : Array[Int]) = {
     for (x <- 0 to arr.length-2){
       val current = x
       for (y <- x+1 to arr.length -1){
         if(arr(y) < arr(current)){
           val swap = arr(current)
           arr(current) = arr(y)
           arr(y) = swap
         }
       }
     }
     arr
   }

  def main(args: Array[String]): Unit = {
    val arr = Array(23,78,45,8,32,46)
    println(sort(arr).mkString(","))
  }

}

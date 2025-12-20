package com.self.Jul2023

object insertionSort  {

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 2, 62, 23, 42, 76, 9, 7, 48)
    println(insertion(arr).mkString(","))
  }
  def insertion(arr: Array[Int]) = {

    val length = arr.length -1;
      for(i <- 0 to length){
        val current = arr(i);
        var j = i -1;
         while(j >= 0 && arr(j) > current) {
           arr(j + 1) = arr(j);
           j = j-1;
         }
        arr(j+1) = current;

      }
    arr
  }



}

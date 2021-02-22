package com.self.scalaPractice

object BubbleSortScala extends App{

  def sort(arr: Array[Int]) ={
    var arrlength = arr.length-2
    while(arrlength>1){
    for(i <- 0 to arrlength){
      arr(i) match {
        case v if arr(i) > arr(i + 1) => {
          val temp = arr(i)
          arr(i) = arr(i + 1)
          arr(i + 1) = temp
        }
        case _ => None
      }
      }
      arrlength -= 1
    }
    arr
  }

  val arr = Array(1, 2, 2, 62, 23, 42, 76, 9, 7, 48)
  sort(arr).foreach(println)

}

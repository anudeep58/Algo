package com.self.practice

object bucketSort extends App{

  def sort( nums: Array[Int]) = {
    val max = nums.reduceLeft(_ max _)
    var arr = Array[Int](max+1)

  }


  val nums = Array(7, 3, 2, 1, 0, 45)
}

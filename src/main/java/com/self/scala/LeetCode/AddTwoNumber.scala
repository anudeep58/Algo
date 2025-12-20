package com.self.scala.LeetCode

class ListNode(_x: Int = 0, _next: ListNode = null) {
     var next: ListNode = _next
     var x: Int = _x
   }

object AddTwoNumber {

  def moveZeroes(nums: Array[Int]): Unit = {
    var i =0
    for(num <- nums){
      num match {
        case x  if (x != 0) => nums(i) = num; i = i+1
        case _ => None
      }
    }
    for(y <- i to nums.length -1){
      nums(y) = 0
    }
    nums.foreach(println)
  }

  def compress(chars: Array[Char]): Int = {
    var count = 0
      chars.toList.groupBy(identity).mapValues(_.size).foreach(x => x._2 match {
        case 1 => count = count +1
        case _ => count = count + x._1.toString.length + x._2.toString.length
      })
    count
  }

  def reverseWords(s: String): String = {
    s.split(" ").foldRight("")((a,b) => b+" "+a).trim
  }

//  def firstMissingPositive(nums: Array[Int]): Int = {
//
////    nums.zipWithIndex.foreach()
//  }

  def main(args: Array[String]): Unit = {
    val d = "blue is the sky"
    println(reverseWords(d))
    //productExceptSelf(d).foreach(println)
  }

}

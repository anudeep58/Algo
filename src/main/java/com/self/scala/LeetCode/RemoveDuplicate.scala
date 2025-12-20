package com.self.scala.LeetCode

object RemoveDuplicate {
  def main(args: Array[String]): Unit = {
    val o = Array(0,0,1,1,1,2,2,3,3,4)
    println(removeDuplicates(o).mkString(","))
  }
  def removeDuplicates(nums: Array[Int]) = {
    var withOutduplicate = Array(nums(0));
    for(i <- 0 to nums.length -2){
      val current = nums(i);
      if(current != nums(i+1)){
        withOutduplicate :+= nums(i+1)
      }

    }
    withOutduplicate
  }

}

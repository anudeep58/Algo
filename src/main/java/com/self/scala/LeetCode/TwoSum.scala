package com.self.scala.LeetCode

import scala.collection.mutable

object TwoSum  {

  def twoSum(arr: Array[Int], number:Int): Array[Int] = {
    val hashmap = new mutable.HashMap[Int,Int]
    var res = new Array[Int](0)
        for(x <- 0 to arr.length-1) {
         hashmap.contains(number - arr(x)) match {
            case true => res = Array(x, hashmap.get(number - arr(x)).get)
            case false => if (x == arr.length - 1) {
               throw new IllegalArgumentException("no solution")
            }
           else{
              hashmap.put(arr(x),x)
            }
          }
        }
    res
    }


  def main(args: Array[String]): Unit = {

    println(twoSum(Array(3, 5, 6, 2), 8).mkString(","))
  }
}

package com.self.hRk

object Staircase {
  def staircase(n: Int) {
    for (x <- 1 to n){
      print(List.fill(n-x)(" ").mkString+List.fill(x)("#").mkString)
      print("\n")
    }

  }
  def findMajority(n: Array[Int]): Unit ={
    val sortarr = n.sortWith(_<_)

  }
  /*def plusMinus(arr: Array[Int]) {
    var positive = 0
    var negative = 0
    var zero = 0
    for (x <- arr){
      x match {
        case x < 0 => negative+1
        case x > 0 => positive+1
        case x==0 => zero+1
      }
      println(positive/arr.length)
      println(negative/arr.length)
      println(zero/arr.length)
    }

  }*/

//  def formingMagicSquare(s: Array[Array[Int]]): Int = {
//      val ss = s.flatMap(x =>x)
//        for(y <- 1 to ss.length){
////          ss -= y
//        }
//  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

//    val n = stdin.readLine.trim.toInt

//    staircase(4)
    val mymultiarr= Array.ofDim[Int](2, 2)
    //Assigning the values
    mymultiarr(0)(0) = 2
    mymultiarr(0)(1) = 7
    mymultiarr(1)(0) = 3
    mymultiarr(1)(1) = 4
    val arr = Array(3, 3, 4, 2, 4, 4, 2, 4, 4)
    findMajority(arr)
//    println(formingMagicSquare(mymultiarr))
  }
}

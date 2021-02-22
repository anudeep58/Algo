package com.self.scalaPractice

import scala.annotation.tailrec

object FactorialScala extends App{
  @tailrec
  def factorial(x: Int, res: Int): Int = {
    x match {
      case 1 =>  res
      case _ => factorial(x-1, res*x)
    }
  }
  println(factorial(5,1))
  println(factorial(3,1))

}

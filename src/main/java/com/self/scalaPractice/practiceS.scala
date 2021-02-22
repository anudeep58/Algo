package com.self.scalaPractice

object practiceS extends App{


  def merge(l1: List[Int], l2: List[Int]): List[Int] = {
    (l1,l2) match {
      case (_,Nil) => l1
      case (Nil,_) => l2
      case (h1::t1,h2::t2) => {
        h1 > h2 match {
          case true => h1 :: merge(t1,l2)
          case false => h2 :: merge(l1,t2)
        }
      }
    }
  }

  def mergeSort(lst: List[Int]) ={
    lst match {
      case Nil => lst
      case h::Nil => lst
      case _ => {
        val (l1,l2) = lst.splitAt(lst.length/2)
        merge(l1,l2)
      }
    }
  }

}

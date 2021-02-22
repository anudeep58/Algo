package com.self.scalaPractice

object MergeSortScala extends App {

  def merge(l1:List[Double],l2:List[Double]):List[Double] ={
    (l1,l2) match {
      case (Nil, _) => l2
      case (_, Nil) => l1
      case (h1 :: t1, h2 :: t2) =>
        if (h1 < h2) h1 :: merge(t1, l2)
        else h2 :: merge(l1, t2)
    }
  }

  def mergesort(lst:List[Double]): List[Double] ={
    lst match {
      case Nil => lst
      case h::Nil => lst
      case _ => {
        val (l1,l2) = lst.splitAt(lst.length/2)
        merge(mergesort(l1),mergesort(l2))
      }
    }
  }
  mergesort(List.fill(10)(math.random)).foreach(println)
}

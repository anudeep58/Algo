package com.self.scalaPractice

import scala.annotation.tailrec

object SortListWithTailRec {

  def sortList(list: List[Int]):List[Int] = {

    def insert(number:Int, sortedList:List[Int]): List[Int] = {
      if(sortedList.isEmpty || number <= sortedList.head) {
        number::sortedList
      }
      else {
        sortedList.head::insert(number,sortedList.tail)
      }
    }
    if(list.isEmpty || list.tail.isEmpty) {list}
    else (insert(list.head,sortList(list.tail)))

  }

  def sortBetter(list:List[Int]):List[Int] = {
    @tailrec
    def insertTailrec(number:Int,sortedList:List[Int],accumulator:List[Int]):List[Int] ={
      if(sortedList.isEmpty || number <= sortedList.head) {
        accumulator.reverse:::number::sortedList
      }
      else {
        insertTailrec(number,sortedList.tail,sortedList.head::accumulator)
      }
    }
    @tailrec
    def sortTailrec(list: List[Int], accumulator:List[Int]):List[Int] = {
      if (list.isEmpty) accumulator
      else sortTailrec(list.tail,insertTailrec(list.head,accumulator,Nil))
    }
    sortTailrec(list,Nil)
  }

  def main(args: Array[String]): Unit = {
    println(sortList(List(2,3,4,1,8,7,6)))
    println(sortBetter((1 to 10000).reverse.toList))
  }

}

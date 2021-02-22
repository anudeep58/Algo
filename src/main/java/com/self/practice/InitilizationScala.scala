package com.self.practice

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object InitilizationScala extends App {
  class aa(val ab: Int,bc: Int){
    def add = {
      ab + bc
    }
  }

  val n = new aa(1,2)
  val ll= mutable.LinkedList[(String,String)]()
  val mylist2 = List("C", "C#", "Java", "Scala",
    "PHP", "Ruby")
  mylist2.reverse
  val a = Array(1, 2, 3)
  a.reduceLeft(_ + _)
  a.foldLeft(20)(_ + _)
  var name = ListBuffer[String]()
  name += "GeeksForGeeks"
  name += "gfg"
  name += "Class"
  println(name.foldRight("a")(_ + _))
  val myMap =
    Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
}

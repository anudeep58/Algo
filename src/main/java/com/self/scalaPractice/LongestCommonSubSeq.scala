package com.self.scalaPractice

object LongestCommonSubSeq extends App{

  def getAllSubstrings(str: String): Set[String] = {
//    str.inits.foreach(println)
    str.inits.flatMap(_.tails).toSet
  }
  def longestCommonSubstring(str1: String, str2: String): String = {
    val str1Substrings = getAllSubstrings(str1)
    val str2Substrings = getAllSubstrings(str2)
//    println(str1Substrings)
    str1Substrings.intersect(str2Substrings).maxBy(_.length)
  }

  def commonElementinSeq(str1:String,str2:String): String = {
    str1.toCharArray.intersect(str2.toCharArray).mkString("")
  }
  println(commonElementinSeq("ABCDGH","AEDFHR"))
  println(longestCommonSubstring("ABCDGH","AEDFHR"))

}

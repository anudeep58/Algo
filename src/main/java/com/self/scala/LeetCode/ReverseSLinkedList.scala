package com.self.scala.LeetCode

//class ListNode(_x: Int = 0, _next: ListNode = null) {
//  var next: ListNode = _next
//  var x: Int = _x
//  }

object ReverseSLinkedList {

  def reverse(node: ListNode): ListNode =
    if (node == null || node.next == null) node
    else {
      val res = reverse(node.next)
      node.next.next = node
      node.next = null
      res
    }

  def main(args: Array[String]): Unit = {

    val l1 = new ListNode()
    l1.x = 1
    l1.next.x = 2
    l1.next.next.x = 3
    l1.next.next.next.x = 5
    val rl = reverse(l1)

      println(rl.x)
      println(rl.next.x)
      println(rl.next.next.x)
    println(rl.next.next.next.x)

  }


}

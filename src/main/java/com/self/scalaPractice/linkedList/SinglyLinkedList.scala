package com.self.scalaPractice.linkedList

class SinglyLinkedList[A] extends ListADT[A] {
  private class Node(var data: A, var nextNode : Node)

  private var head:Node = null

  def apply(index:Int) :A= {
    require(index >=0)
    var rover = head
    for (i <- 0 until index){
      rover = rover.nextNode
    }
    rover.data
  }

  def update(index:Int, data:A): Unit = {
    require(index >=0)
    var rover = head
    for (i <- 0 until index){
      rover = rover.nextNode
    }
    rover.data = data
  }
  def insert(index:Int, data:A): Unit = {
    require(index >=0)
    if(index == 0){
      head = new Node(data,head)
    }
    var rover = head
    for (i <- 0 until index-1){
      rover = rover.nextNode
      rover.nextNode = new Node(data,rover.nextNode)
    }
  }
  def remove(index: Int): A = ???
}

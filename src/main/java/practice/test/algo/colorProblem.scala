package practice.test.algo

import scala.collection.mutable


/*

Lets say you have N unpainted balls numbered from 1 to N. By unpainted, we mean that each ball initially has a value of 0.
You have to process Q queries of the form l r c, in which you paint all the balls from index l to index r with color c.
Assume that, each new color currently being applied to a ball overrides its previous color.
Output the color of each ball after all the queries have been processed.

Input
-----
4 3
1 3 2
2 4 6
2 3 7

Output
------
2
7
7
6
 */

object colorProblem extends App {

  var colorMap = mutable.Map[Int,Int]()
  case class inpuut(val s: Int, val e: Int, color: Int)

  def changeColor(inputs : List[inpuut]) = {
    for(x <- inputs.length-1 to 0 by -1) {
      for (y <- inputs(x).s to inputs(x).e) {
        if (!colorMap.contains(y)) {
          colorMap += (y -> inputs(x).color)
        }
      }

    }
    colorMap
    }

   val input1 = inpuut(1 ,3 ,2)
   val input2 = inpuut(2 ,4 ,6)
   val input3 = inpuut(2 ,3 ,7)

    val lst = List(input1,input2,input3)
    changeColor(lst).foreach(println)

  }


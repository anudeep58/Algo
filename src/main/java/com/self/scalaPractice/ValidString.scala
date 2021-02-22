package com.self.scalaPractice

object ValidString extends App{

    // Complete the isValid function below.
    def extraLongFactorials(n: Int)= {
        def factorial(n:Int, result: BigInt =1): BigInt={
          n match {
            case x if x == 1 || x == 0=> result
            case _ => factorial(n-1,result*n)
          }
        }
      factorial(n)
    }

    def isValid(s: String) = {
      val sizeA = s.toCharArray.groupBy(identity).mapValues(_.size).values.groupBy(i=>i).mapValues(_.size)
      sizeA.size match {
        case y if y >2 => "NO"
        case y if y == 2 => {
          val min = sizeA.maxBy(_._2)._1
          sizeA.filterKeys(!_.equals(min)).head._1 match {
            case f if f == min +1 || f ==1=> {
              sizeA(sizeA.filterKeys(!_.equals(min)).head._1) match {
                case 1 => "YES"
                case _ => "NO"
              }
            }
            case _ => "NO"
          }

        }
        case _ => "YES"
      }
    }

  def birthdayCakeCandles(candles: Array[Int]): Int = {
    // Write your code here
    candles.groupBy(identity).mapValues(_.size).maxBy(_._2)._2

  }

    def specialString(str: String) ={
      for(x<-str.inits.flatMap(_.tails).toList.filter(_.size match {
        case x if x%2 != 0 => true
        case _ => false
      })) yield x.splitAt(x.size/2)._1 == x.splitAt(x.size/2)._2.reverse  match {
        case true => x
        case false =>
      }
    }
      val stdin = scala.io.StdIn

//      val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

//  val result = specialString("mnonopoo")
  println(extraLongFactorials(20))
//  /*printWriter.*/println(result)

  //      printWriter.close()
  //      val s = stdin.readLine





}

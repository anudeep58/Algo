import scala.annotation.tailrec

object binary {
    def main(args: Array[String]){
      val l = List(1,2,4,5,6, 8,9,25,31);
      println("Hello World!")
      println(search(5, l))
      println(search(6, l))
      println(search(7, l))
    }

    def search(target:Int, l:List[Int]) = {
      @tailrec
      def recursion(low:Int, high:Int):Option[Int] = (low+high)/2 match{
        case _ if high < low => None
        case mid if l(mid) > target => recursion(low, mid-1)
        case mid if l(mid) < target => recursion(mid+1, high)
        case mid if l(mid) == target => Some(mid)
      }
      recursion(0,l.size - 1)
    }
}
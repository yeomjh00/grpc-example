import scala.io.Source
import java.nio.file.{Files, Paths}
import scala.collection.mutable.ListBuffer

object Main {
  def main(args: Array[String]): Unit = {
    val fileName = args.head.toString
    val fileNum = args.tail.head.toInt
    var veryFirstLine : String = ""
    var veryLastLine : String =""
    var boundaryList : ListBuffer[String] = ListBuffer()
    for(i <- 0 until fileNum){
      val filePath = s"./${fileName}.${i}"
      val keyList = Source.fromFile(filePath).getLines().map(_.splitAt(10)._1).toList
      val first = keyList.head
      val remain = keyList.tail
      if(i == 0) {
        veryFirstLine = first
      }
      else if(i + 1 ==fileNum){
        veryLastLine = remain.last
      }
      boundaryList.append(first)
      boundaryList.append(remain.last)
      // println(f"first line is ${first} last line is ${remain.last}")
      var order = true
      var prev = first
      var cnt = 0
      for(line <- remain){
        if(prev > line){
          order = false
          // println(f"${prev} > ${line}")
        }
        prev = line
      }
      println(f"${fileName}.${i} order is ${order}")
    }

    val first = boundaryList.head
    val remain = boundaryList.tail
    var order = true
    var prev = first
    for(line <- remain){
      if(prev > line){
        order = false
        // println(f"${prev} > ${line}")
      }
      prev = line
    }
    println(f"all order is ${order}")
    println(f"first line is <${veryFirstLine}> last line is <${veryLastLine}>")
  }
}
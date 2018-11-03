package org.entu.essential.scala.sequencing.computations

import org.entu.essential.scala.sequencing.computations.genericmodeling.{Empty, Full}

object SequencingComputations {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3)
    println(list.flatMap(el => List(el, -el)))
    println(list.map(el => List(el, -el)))

    val list2 = List(Full(3), Full(2), Full(1))
    print(list2.map(maybe => maybe.flatMap(x => if (x % 2 == 0) Full(x) else Empty)))
  }
}

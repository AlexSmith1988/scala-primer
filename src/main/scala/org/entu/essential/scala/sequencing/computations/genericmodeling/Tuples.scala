package org.entu.essential.scala.sequencing.computations.genericmodeling

object Tuples {
  def main(args: Array[String]): Unit = {
    println(("hi", 1, true).getClass)
    println(tuplized(("Hi", 2)))
    val t = ("1", 2)
  }

  def tuplized[A, B](in: (A, B)): A = in._1
}

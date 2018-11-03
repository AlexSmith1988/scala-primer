package org.entu.essential.scala.sequencing.computations.genericmodeling

import org.scalatest.Assertions._

object Pairs {

  def main(args: Array[String]): Unit = {
    val pair = Pair[String, Int]("hi", 2)

    assert(pair.one == "hi")
    assert(pair.two == 2)
  }

}

final case class Pair[A, B](one: A, two: B)

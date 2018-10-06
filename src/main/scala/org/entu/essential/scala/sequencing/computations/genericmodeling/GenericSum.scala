package org.entu.essential.scala.sequencing.computations.genericmodeling

import org.scalatest.Assertions._

object GenericSum {
  def main(args: Array[String]): Unit = {
    assert(Left(1).value == 1)
    assert(Right("Test").value == "Test")
    val sum: Sum[Int, String] = Right("foo")

    assert(
      "foo" ==
        (sum match {
          case Left(value) => value.toString
          case Right(value) => value
        }))
  }
}

sealed trait Sum[A, B]

final case class Left[A, B](value: A) extends Sum[A, B]

final case class Right[A, B](value: B) extends Sum[A, B]


package org.entu.essential.scala.sequencing.computations.genericmodeling

import org.scalatest.Assertions._

object GenericSum {
  def main(args: Array[String]): Unit = {
    assert(Left(1).fold(String.valueOf, identity) == "1")
    assert(Right("Test").value == "Test")
    val sum: Sum[Int, String] = Right("foo")

    assert("foo" == sum.fold(String.valueOf , identity))
  }
}

sealed trait Sum[A, B] {
  def fold[C](left: A => C, right: B => C): C =
    this match {
      case Left(value) => left(value)
      case Right(value) => right(value)
    }
}

final case class Left[A, B](value: A) extends Sum[A, B]

final case class Right[A, B](value: B) extends Sum[A, B]


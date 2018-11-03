package org.entu.essential.scala.sequencing.computations.genericmodeling

import org.scalatest.Assertions._

object GenericSum {
  def main(args: Array[String]): Unit = {
    assert(Failure(1).fold(String.valueOf, identity) == "1")
    assert(Success("Test").value == "Test")
    val sum: Sum[Int, String] = Success("foo")

    assert("foo" == sum.fold(String.valueOf, identity))
  }
}

sealed trait Sum[A, B] {
  def fold[C](error: A => C, success: B => C): C =
    this match {
      case Failure(value) => error(value)
      case Success(value) => success(value)
    }

  def map[C](f: B => C): Sum[A, C] =
    this match {
      case Success(value) => Success(f(value))
      case Failure(value) => Failure(value)
    }

  def flatMap[C](f: B => Sum[A, C]): Sum[A, C] =
    this match {
      case Failure(value) => Failure(value)
      case Success(value) => f(value)
    }
}

final case class Failure[A, B](value: A) extends Sum[A, B]

final case class Success[A, B](value: B) extends Sum[A, B]


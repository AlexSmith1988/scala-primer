package org.entu.essential.scala.sequencing.computations

import scala.annotation.tailrec

object GenericLists {
  def main(args: Array[String]): Unit = {
    Pair(10, Pair(15, Pair(20, End())))
    Pair("Hello", Pair(", ", Pair("World", End())))

    val example = Pair(1, Pair(2, Pair(3, End())))
    assert(example.length == 3)
    assert(example.tail.length == 2)
    assert(End().length == 0)

    assert(example.contains(3))
    assert(!example.contains(4))
    assert(!End().contains(0))
    // This should not compile
    // example.contains("not an Int")

    assert(example(0) == Success(1))
    assert(example(1) == Success(2))
    assert(example(2) == Success(3))
    assert(example(3) == Failure("Index out of bounds"))
  }
}

sealed trait LinkedList[A] {
  @tailrec
  final def length(running: Int = 0): Int =
    this match {
      case Pair(_, tail) => tail.length(running + 1)
      case _ => running
    }

  def length: Int = length()

  def contains(value: A): Boolean =
    this match {
      case Pair(actual, tail) => if (actual == value) true else tail.contains(value)
      case _ => false
    }

  def apply(offset: Int): Result[A] =
    this match {
      case Pair(head, tail) => if (offset == 0) Success(head) else tail(offset - 1)
      case _ => Failure("Index out of bounds")
    }
}

final case class End[A]() extends LinkedList[A]

final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

sealed trait Result[A]

case class Success[A](result: A) extends Result[A]

case class Failure[A](reason: String) extends Result[A]
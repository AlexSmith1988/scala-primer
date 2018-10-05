package org.entu.essential.scala.sequencing.computations.functions

import org.scalatest.Assertions._

object RecursiveData {
  def main(args: Array[String]): Unit = {
    val example = Pair(1, Pair(2, Pair(3, RecursiveEnd)))
    assert(example.sum == 6)
    assert(example.tail.sum == 5)
    assert(RecursiveEnd.sum == 0)

    assert(example.length == 3)
    assert(example.tail.length == 2)
    assert(RecursiveEnd.length == 0)

    assert(example.product == 6)
    assert(example.tail.product == 6)
    assert(RecursiveEnd.product == 1)

    assert(example.double == Pair(2, Pair(4, Pair(6, RecursiveEnd))))
    assert(example.tail.double == Pair(4, Pair(6, RecursiveEnd)))
    assert(RecursiveEnd.double == RecursiveEnd)
  }
}

sealed trait IntList {
  def sum: Int = fold(0, (x, y: Int) => x + y)

  def length: Int = fold(0, (_, y: Int) => 1 + y)

  def product: Int = fold(1, (x, y: Int) => x * y)

  def fold[A](end: A, f: (Int, A) => A): A =
    this match {
      case Pair(head, tail) => f(head, tail.fold(end, f))
      case _ => end
    }

  def double: IntList = fold(RecursiveEnd, (x, y: IntList) => Pair(2 * x, y))

  def map(f: Int => Int): IntList =
    this match {
      case Pair(head, tail) => Pair(f(head), tail.map(f))
      case _ => RecursiveEnd
    }
}

case object RecursiveEnd extends IntList

final case class Pair(head: Int, tail: IntList) extends IntList

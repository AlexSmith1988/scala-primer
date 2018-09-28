package org.entu.essential.scala.traits.recursivedata.example

import scala.annotation.tailrec

object RecursiveData extends App {
  println(Pair(1, Pair(2, Pair(3, End))))
  println(Array(1, 2, 3, 4))

  val example = Pair(1, Pair(2, Pair(3, End)))
  assert(sum(example) == 6)
  assert(sum(example.tail) == 5)
  assert(sum(End) == 0)

  assert(example.length == 3)
  assert(example.tail.length == 2)
  assert(End.length == 0)

  assert(example.product == 6)
  assert(example.tail.product == 6)
  assert(End.product == 1)

  assert(example.double == Pair(2, Pair(4, Pair(6, End))))
  assert(example.tail.double == Pair(4, Pair(6, End)))
  assert(End.double == End)

  @tailrec
  def sum(list: IntList, total: Int = 0): Int =
    list match {
      case End => total
      case Pair(head, tail) => sum(tail, head + total)
    }
}

sealed trait IntList {
  def length: Int = length()

  @tailrec
  final def length(total: Int = 0): Int = {
    this match {
      case End => total
      case Pair(_, tail) => tail.length(total + 1)
    }
  }

  def product: Int = product()

  @tailrec
  final def product(total: Int = 1): Int = {
    this match {
      case End => total
      case Pair(head, tail) => tail.product(total * head)
    }
  }

  final def double: IntList = {
    this match {
      case End => End
      case Pair(head, tail) => Pair(2 * head, tail.double)
    }
  }
}

case object End extends IntList

final case class Pair(head: Int, tail: IntList) extends IntList

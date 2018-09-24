package org.entu.essential.scala.traits.recursivedata

object RecursiveData extends App {
  println(Pair(1, Pair(2, Pair(3, End))))
  println(Array(1, 2, 3, 4))

  val example = Pair(1, Pair(2, Pair(3, End)))
  assert(sum(example) == 6)
  assert(sum(example.tail) == 5)
  assert(sum(End) == 0)

  def sum(list: IntList): Int =
    list match {
      case End => 0
      case Pair(head, tail) => head + sum(tail)
    }
}

sealed trait IntList

case object End extends IntList

final case class Pair(head: Int, tail: IntList) extends IntList
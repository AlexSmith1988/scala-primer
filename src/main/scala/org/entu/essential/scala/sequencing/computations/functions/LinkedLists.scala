package org.entu.essential.scala.sequencing.computations.functions

object LinkedLists {
  def main(args: Array[String]): Unit = {

  }
}

sealed trait LinkedList[A] {
  def fold[B](end: () => B, pair: (A, B) => B): B =
    this match {
      case Pair2(head, tail) => pair(head, tail.fold(end, pair))
      case _ => end()
    }
}

final case class Pair2[A](head:A, tail: LinkedList[A]) extends LinkedList[A]
final case class End[A]() extends LinkedList[A]

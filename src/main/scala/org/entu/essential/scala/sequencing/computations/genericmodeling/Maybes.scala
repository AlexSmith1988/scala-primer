package org.entu.essential.scala.sequencing.computations.genericmodeling

object Maybes {
  def main(args: Array[String]): Unit = {
    val empty: Maybe[Int] = Empty()
    println(empty)
    // perhaps: Maybe[Int] = Empty()

    val full: Maybe[Int] = Full(1)
    println(full)
    // perhaps: Maybe[Int] = Full(1)
  }
}

sealed trait Maybe[A] {

  def fold[B](empty: B, full: A => B): B =
    this match {
      case Empty() => empty
      case Full(value) => full(value)
    }

  def flatMap[B](mapping: A => Maybe[B]): Maybe[B] =
    this match {
      case Empty() => Empty()
      case Full(value) => mapping(value)
    }

  def map[B](mapping: A => B): Maybe[B] =
    this match {
      case Empty() => Empty()
      case Full(value) => Full(mapping(value))
    }

  def mapf[B](mapping: A => B): Maybe[B] = flatMap(a => Full(mapping(a)))
}

final case class Full[A](value: A) extends Maybe[A]

final case class Empty[A]() extends Maybe[A]


package org.entu.essential.scala.sequencing.computations

import org.entu.essential.scala.sequencing.computations.genericmodeling.{Empty, Full, Maybe}


object Users {
  def main(args: Array[String]): Unit = {
    val t = Pair(1, Pair(2, End())).map(load)
    println(t)
  }

  def load(id: Int): Maybe[User] =
    id % 2 match {
      case 1 => Full(User(id))
      case 0 => Empty()
    }
}

final case class User(id: Int)

final case class Order(value: Double)

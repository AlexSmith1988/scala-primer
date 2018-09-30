package org.entu.essential.scala.traits.recursivedata

import scala.annotation.tailrec

object TailRecFactorial extends App {
  println(factorial(5) == 120)

  @tailrec
  def factorial(n: Int, running: Int = 1): Int =
    n match {
      case 0 => running
      case any => factorial(any - 1, any * running)
    }
}

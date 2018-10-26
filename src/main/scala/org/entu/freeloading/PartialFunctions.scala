package org.entu.freeloading

object PartialFunctions {

  def main(args: Array[String]): Unit = {

    val value : PartialFunction[Int, Int] = {
      case i if i % 2 == 0 => 10
    }

    println(value(2))
  }

}

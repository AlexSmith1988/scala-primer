package org.entu.freeloading

object CallByNamAndByValue {
  def main(args: Array[String]): Unit = {
    println("callByName")
    callByName(something())
    println()
    println("callByValue")
    callByValue(something())
  }

  def something(): Int = {
    println("calling something")
    1 // return value
  }

  def callByValue(x: Int): Unit = {
    println("x1=" + x)
    println("x2=" + x)
  }

  def callByName(x: => Int): Unit = {
    println("x1=" + x)
    println("x2=" + x)
  }
}

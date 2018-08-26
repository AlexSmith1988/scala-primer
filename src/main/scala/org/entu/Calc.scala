package org.entu

object Calc {

  def main(args: Array[String]): Unit = {
    println(cube(10))
    println(step(5))
    println(operation(f = (_: Int, _: Int) => "Hello"))
  }

  def square(x: Double) = x * x

  def cube(x: Double) = square(x) * x

  def step(x: Int) = if (x > 10) true else false

  def operation(x: Int = 1, f: (Int, Int) => Any = (x: Int, y: Int) => x + y, y: Int = 2) = f(x, y)

}

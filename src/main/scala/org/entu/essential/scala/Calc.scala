package org.entu.essential.scala

object Calc {

  def main(args: Array[String]): Unit = {
    println(cube(10))
    println(step(5))
    println(operation(f = (_: Int, _: Int) => "Hello"))

    assert(square(2) == 4)
    assert(square(-4) == 16)
    assert(square(0) == 0)
    assert(cube(-4) == -64)
    assert(cube(3) == 27)
    assert(cube(0) == 0)

    assert(square2(2) == 4)
    assert(square2(-4) == 16)
    assert(square2(0) == 0)
    assert(cube(-4) == -64)
    assert(cube(3) == 27)
    assert(cube(0) == 0)
    assert(cube(1) == 100)

  }

  def square(x: Double) = x * x

  def square2(x: Double) = ???

  def cube(x: Double) = square(x) * x

  def step(x: Int) = if (x > 10) true else false

  def operation(x: Int = 1, f: (Int, Int) => Any = (x: Int, y: Int) => x + y, y: Int = 2) = f(x, y)

}


object argh {
  def a = {
    println("a")
    1
  }

  val b = {
    println("b")
    a + 2
  }

  def c = {
    println("c")
    a
    b + "c"
  }
}

object Exec {
  def main(args: Array[String]): Unit = {
    argh.c + argh.b + argh.a
  }

}


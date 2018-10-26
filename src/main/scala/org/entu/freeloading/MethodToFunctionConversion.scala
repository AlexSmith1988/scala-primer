package org.entu.freeloading

object MethodToFunctionConversion {
  def main(args: Array[String]): Unit = {
    val test2: Int => Int = test
    println(test2)

    val foo = Foo(42)
    val calculate = Bar(foo).calculate _
    execute(calculate)
    foo.value = 15
    execute(calculate)
  }

  def test(x: Int): Int = 10 + x

  def execute(f: Int => Unit): Unit = f(5)

}

case class Foo(var value: Int)

case class Bar(value: Foo) {
  def calculate(multiplier: Int): Unit = println(value.value * multiplier)
}
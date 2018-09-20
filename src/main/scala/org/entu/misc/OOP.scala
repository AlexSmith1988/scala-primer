package org.entu.misc

object OOP {
  def main(args: Array[String]): Unit = {
    power.output = new Output {
      override def simple[Any](subject: Any): Any = {
        println(subject)
        subject
      }
    }

    power.cube(10)
  }
}

trait Output {
  def simple[x](subject: x) : x
}

object power {
  var output: Output = _

  def cube(value: Double): Double = output.simple(value * value * value)
}

// all class fields should be final
// non-final class fields should be long-lasting class state
// not a set of data it currently processes
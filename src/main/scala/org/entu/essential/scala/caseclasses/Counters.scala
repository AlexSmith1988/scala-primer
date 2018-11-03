package org.entu.essential.scala.caseclasses

import org.scalatest.Assertions._

object Counters {
  def main(args: Array[String]): Unit = {
    assert(Counter(10).inc.dec.inc.inc.count == 12)
    assert(
      Counter(10)
        .inc(3)
        .dec(2)
        .inc(1)
        .inc(0)
        .count == 12)
    val count = Counter(42, Adder(7)).count
    assert(count == 49, s"$count should have been 49")
    assert(Counter().inc.dec == Counter().dec(10).inc(10))
  }
}

case class Counter(count: Int = 0) {
  def inc(amount: Int = 1): Counter = copy(count + amount)

  def inc: Counter = inc()

  def dec(amount: Int = 1): Counter = copy(count - amount)

  def dec: Counter = dec()

  def adjust(adder: Adder): Counter = copy(adder(count))

  def adjust2(func: Int => Int): Counter = Counter(func(count))
}

object Counter {
  def apply(count: Int, adder: Adder): Counter = Counter(count).adjust(adder)
}

case class Adder(amount: Int) {
  def apply(in: Int): Int = in + amount
}
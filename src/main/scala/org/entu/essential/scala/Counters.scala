package org.entu.essential.scala

object Counters {
  def main(args: Array[String]): Unit = {
    assert(new Counter(10).inc.dec.inc.inc.count == 12)
    assert(
      new Counter(10)
        .inc(3)
        .dec(2)
        .inc(1)
        .inc(0)
        .count == 12)
    val count = Counter(new Adder(7)).count
    assert(count == 49, s"$count should have been 49")
  }
}

class Counter(val count: Int = 10) {
  def inc(amount: Int = 1) = new Counter(count + amount)

  def inc: Counter = inc()

  def dec(amount: Int = 1) = new Counter(count - amount)

  def dec: Counter = dec()

  def apply(adder: Adder) = new Counter(adder.apply(count))
}

object Counter {
  def apply(adder: Adder): Counter = apply(42, adder)
  def apply(amount: Int = 10, adder: Adder) = new Counter(amount)(adder)
}

class Adder(amount: Int) {
  def apply(in: Int): Int = in + amount
}
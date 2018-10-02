
(_: Int) * 2
res0(_)

(_: Int) * 2 + (_: Int)

res2(1, 2)

object Sum {
  def sum(x: Int, y: Int) = x + y
}

object Add {
  def add1(num: Int): Int = num + 1
}

Sum.sum _

case class Test[A](count: A) {
  def adjust(func: A => A) = Test(func(count))
}

Test(2).adjust(Add.add1)
Test("Yeah").adjust(_ + " Wow")


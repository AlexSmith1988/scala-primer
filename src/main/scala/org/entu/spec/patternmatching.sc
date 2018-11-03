
val s = 10

// Literal pattern
s match {
  case 1 | 2 | 3 => println("Wrong")
  case 9 | 10 | 11 => println("Right")
}

// Simple any variable pattern
s match {
  case x => print(x)
}

// Type pattern
val str: Any = "10"
str match {
  case Int => println("Wrong")
  case _: String => println("Right")
  // additional Pattern
  case s@Double => println(s"$s is Double")
  case _ => print("Wrong")
}

// Pattern binder
case class MyPattern()

val r = MyPattern()
r match {
  case x@MyPattern() => println(s"Right $x")
  case _ => println("No match...")
}

// Paths
class C {
  def action(): Unit = println("Action " + this.getClass)

  def thisTest(): Unit = C.this.action
}

new C().thisTest()

class D extends C {
  def superTest = D.super.thisTest()
}

new D().superTest

trait F {
  def action2 = println("Action F")
}

class E extends D with F {
  def superTest2 = E.super[F].action2
}

new E().superTest2

// Stable identifiers
def testStabelIds(): Unit = {
  val Stable = 10
  val unstable = 15
  s match {
    case `unstable` => print(s"Matched unstable id $unstable")
    case Stable => print("Matched stable id")
  }
}

testStabelIds()

// Tuple pattern
val tuple = (9, 10, 11)
tuple match {
  case (1, 2, 3) => println("Matched first")
  case (9, 10, 11) => print("Matched second")
}
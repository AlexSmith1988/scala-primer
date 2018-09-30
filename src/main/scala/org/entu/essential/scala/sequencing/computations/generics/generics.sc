def generic[A](in: A): A = in

generic("foo")

final case class Box[A](value: A)

Box(2)

res1.value

Box("hi")

res3.value

generic(1)

Box(new Object)

sealed trait Result[A]
final case class Success[A](result: A)
extends Result[A]
final case class Failure[A](reason: String)
extends Result[A]





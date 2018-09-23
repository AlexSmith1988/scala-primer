package org.entu.essential.scala.traits

object DivisionExercise extends App {
  assert(divide(10, 0) == Infinite)
  assert(divide(10, 7) == Finite(1))

  println(divide(divide(30, 0)))
  println(divide(divide(20, 7)))
}

object divide {
  def apply(divisable: Int, divisor: Int): DivisionResult =
    if (divisor == 0) Infinite else Finite(divisable / divisor)

  def apply(divisionResult: DivisionResult): String =
    divisionResult match {
      case Infinite => "Division result not defined"
      case Finite(result) => s"Division result $result"
    }
}

sealed trait DivisionResult

case object Infinite extends DivisionResult

final case class Finite(result: Int) extends DivisionResult


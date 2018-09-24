package org.entu.essential.scala.traits.modeling

object Calculator extends App {
  print(execute)

  assert(Calculator + (Success(1), 1) == Success(2))
  assert(Calculator - (Success(1), 1) == Success(0))
  assert(Calculator + (Failure("Badness"), 1) == Failure("Badness"))

  assert(Calculator / (Success(4), 2) == Success(2))
  assert(Calculator / (Success(4), 0) == Failure("Division by zero"))
  assert(Calculator / (Failure("Badness"), 0) == Failure("Badness"))

  def execute: Calculation = Success(10)

  def +(calculation: Calculation, operand: Int) =
    calculation match {
      case Failure(_) => calculation
      case Success(result) => Success(result + operand)
    }

  def -(calculation: Calculation, operand: Int) =
    calculation match {
      case Failure(_) => calculation
      case Success(result) => Success(result - operand)
    }

  def /(calculation: Calculation, operand: Int) =
    calculation match {
      case Failure(_) => calculation
      case Success(result) =>
        operand match {
          case 0 => Failure("Division by zero")
          case _ => Success(result / operand)
        }
    }

}

sealed trait Calculation

final case class Failure(message: String) extends Calculation

final case class Success(result: Int) extends Calculation

package org.entu.essential.scala.traits.extendedexamples

object Calculator {
  def main(args: Array[String]): Unit = {
    val expression1 = Addition(Number(10), Subtraction(Number(20), Number(15)))
    assert(expression1.evaluate == Success(15))
    val expression2 = Addition(Number(10), Subtraction(Division(Number(30), Number(0)), Number(15)))
    assert(expression2.evaluate == Failure("Division by zero"))

    assert(Addition(SquareRoot(Number(-1.0)), Number(2.0)).evaluate ==
      Failure(s"Square root of -1.0 - a negative number"))
    assert(Addition(SquareRoot(Number(4.0)), Number(2.0)).evaluate == Success(4.0))
    assert(Division(Number(4), Number(0)).evaluate == Failure("Division by zero"))


    assert(Addition(SquareRoot(Number(-1.0)), Number(2.0)).eval ==
      Failure(s"Square root of negative number"))
    assert(Addition(SquareRoot(Number(4.0)), Number(2.0)).eval == Success(4.0))
    assert(Division(Number(4), Number(0)).eval == Failure("Division by zero"))
  }
}

sealed trait Expression {
  def evaluate: Calculation =
    this match {
      case binaryExpression: BinaryExpression =>
        binaryExpression.left.evaluate match {
          case Success(leftValue) =>
            binaryExpression.right.evaluate match {
              case Success(rightValue) =>
                binaryExpression match {
                  case Addition(_, _) => Success(leftValue + rightValue)
                  case Subtraction(_, _) => Success(leftValue - rightValue)
                  case Division(_, _) =>
                    rightValue match {
                      case 0 => Failure("Division by zero")
                      case _ => Success(leftValue / rightValue)
                    }
                }

              case failure => failure
            }
          case failure => failure
        }

      case SquareRoot(expression) =>
        expression.evaluate match {
          case Success(value) =>
            if (value < 0)
              Failure(s"Square root of $value - a negative number")
            else
              Success(Math.sqrt(value))
          case failure => failure
        }

      case Number(value) => Success(value)
    }

  def eval: Calculation =
    this match {
      case Addition(l, r) =>
        l.eval match {
          case Failure(reason) => Failure(reason)
          case Success(r1) =>
            r.eval match {
              case Failure(reason) => Failure(reason)
              case Success(r2) => Success(r1 + r2)
            }
        }
      case Subtraction(l, r) =>
        l.eval match {
          case Failure(reason) => Failure(reason)
          case Success(r1) =>
            r.eval match {
              case Failure(reason) => Failure(reason)
              case Success(r2) => Success(r1 - r2)
            }
        }
      case Division(l, r) =>
        l.eval match {
          case Failure(reason) => Failure(reason)
          case Success(r1) =>
            r.eval match {
              case Failure(reason) => Failure(reason)
              case Success(r2) =>
                if (r2 == 0)
                  Failure("Division by zero")
                else
                  Success(r1 / r2)
            }
        }
      case SquareRoot(v) =>
        v.eval match {
          case Success(r) =>
            if (r < 0)
              Failure("Square root of negative number")
            else
              Success(Math.sqrt(r))
          case Failure(reason) => Failure(reason)
        }
      case Number(value) => Success(value)
    }
}

sealed trait BinaryExpression extends Expression {
  def left: Expression

  def right: Expression
}

final case class Addition(left: Expression, right: Expression) extends BinaryExpression

final case class Subtraction(left: Expression, right: Expression) extends BinaryExpression

final case class Division(left: Expression, right: Expression) extends BinaryExpression

final case class SquareRoot(expression: Expression) extends Expression

final case class Number(value: Double) extends Expression

sealed trait Calculation

final case class Success(value: Double) extends Calculation

final case class Failure(reason: String) extends Calculation


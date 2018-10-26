package org.entu.freeloading

import org.entu.freeloading.PartiallyAppliedDefs.{ge, le}

object PartiallyApplied {
  def main(args: Array[String]): Unit = {

  }
}

case class Email(subject: String,
                 text: String,
                 sender: String,
                 recipient: String) {
  def test() = 10
}


trait EmailFilter extends (Email => Boolean)

trait IntPairPred extends ((Int, Int) => Boolean)

object PartiallyAppliedDefs {

  def sizeConstraint(pred: IntPairPred, n: Int, email: Email) = pred(email.text.length, n)

  val gt: IntPairPred = _ > _
  val ge: IntPairPred = _ >= _
  val lt: IntPairPred = _ < _
  val le: IntPairPred = _ <= _
  val eq: IntPairPred = _ == _

  val minimumSize: (Int, Email) => Boolean = sizeConstraint(ge, _: Int, _: Email)
  val maximumSize: (Int, Email) => Boolean = sizeConstraint(le, _: Int, _: Email)

  val constr20: (IntPairPred, Email) => Boolean = sizeConstraint(_: IntPairPred, 20, _: Email)
  val constr30: (IntPairPred, Email) => Boolean = sizeConstraint(_: IntPairPred, 30, _: Email)

  val min20: EmailFilter = minimumSize(20, _: Email)
  val max20: EmailFilter = maximumSize(20, _: Email)
}

object SpicedUpFunctions {
  def sizeConstraint(pred: IntPairPred)(n: Int)(email: Email): Boolean =
    pred(email.text.size, n)

  val sizeConstraintFn: IntPairPred => Int => Email => Boolean = sizeConstraint

  val minSize: Int => Email => Boolean = sizeConstraintFn(ge)
  val maxSize: Int => Email => Boolean = sizeConstraintFn(le)

  val min20: Email => Boolean = minSize(20)
  val max20: Email => Boolean = maxSize(20)

  val sum: (Int, Int) => Int = _ + _
  val sumCurried: Int => Int => Int = sum.curried

  private val function: (Int, Int) => Int = Function.uncurried(sumCurried)


}
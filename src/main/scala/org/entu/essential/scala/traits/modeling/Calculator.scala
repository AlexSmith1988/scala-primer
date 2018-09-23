package org.entu.essential.scala.traits.modeling


object Calculator extends App {
  print(execute)

  private def execute: Calculation = Success(10)

  private sealed trait Calculation

  private final case class Failure(message: String) extends Calculation

  private final case class Success(result: Int) extends Calculation

}




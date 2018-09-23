package org.entu.essential.scala.traits.modeling

object MultipleInheritanceTest extends App {
  val c: C = D()
  println(s"${c.act} ${c.execute}")
}

sealed trait A {
  def act = 10
}

sealed trait B {
  def act = 20

  def execute: Int
}

sealed trait B2 {
  def execute = 50
}

sealed trait C extends A with B with B2 {
  override def act = 30
}

final case class D() extends C
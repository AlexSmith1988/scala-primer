package org.entu.essential.scala.traits

object MoreCats extends App {
  assert("roar" ==Tiger("yellow").sound)
}

trait Feline {
  def colour: String

  def sound: String
}

case class Cat(colour: String) extends Feline {
  val sound = "meow"
}

trait BigCat extends Feline {
  val sound = "roar"
}

case class Tiger(colour: String) extends BigCat

case class Lion(colour: String, maneSize: Int) extends BigCat

case class Panther(colour: String) extends BigCat

package org.entu.essential.scala.patternmatching

import org.entu.essential.scala.Cat

object ChipShop {

  def main(args: Array[String]): Unit = {
    val oswald = new Cat("Oswald", "Black", "Milk")
    val henderson = new Cat("Henderson", "Ginger", "Chips")
    val quentin = new Cat(name = "Quentin", colour = "Tabby and white", food = "Curry")

    assert(willServe(henderson))
    assert(!willServe(quentin))
  }

  def willServe(cat: Cat): Boolean = {
    CatMatcher(cat) match {
      case CatMatcher(_, _, "Chips") => true
      case CatMatcher(_, _, _) => false
    }
  }

}

case class CatMatcher(name: String, colour: String, food: String)

object CatMatcher {
  def apply(cat: Cat): CatMatcher = CatMatcher(cat.name, cat.colour, cat.food)
}

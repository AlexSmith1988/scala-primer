package org.entu.essential.scala

class Cat(val name: String, val colour: String, val food: String)

object ChipShop {
  def willServe(cat: Cat) = cat.food == "Chips"
}

object CatsClasses {
  def main(args: Array[String]): Unit = {
    val oswald = new Cat("Oswald", "Black", "Milk")
    val henderson = new Cat("Henderson", "Ginger", "Chips")
    val quentin = new Cat(name = "Quentin", colour = "Tabby and white", food = "Curry")

    println(s"$oswald $henderson $quentin")


  }
}
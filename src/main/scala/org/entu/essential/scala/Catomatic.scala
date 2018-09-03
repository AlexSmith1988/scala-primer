package org.entu.essential.scala

object Black

object Ginger

object TabbyAndWhite {
  override def toString: String = getClass getSimpleName
}

object Milk

object Chips

object Curry {
  override def toString: String = getClass getSimpleName
}


object Cat1 {
  val name = "Oswald"
  val color = Black
  val food = Milk
}

object Cat2 {
  val name = "Henderson"
  val color = Ginger
  val food = Chips
}

object Cat3 {
  val name = "Quentin"
  val color = TabbyAndWhite
  val food = Curry

  override def toString = String.join(" ", name, color.toString, food.toString)
}

object Catomatic {
  def main(args: Array[String]): Unit = {
    println(Cat3.toString)

    println(List(1,2,3) tail)
  }
}


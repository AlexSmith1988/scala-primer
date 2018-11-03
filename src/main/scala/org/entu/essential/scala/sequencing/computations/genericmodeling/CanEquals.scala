package org.entu.essential.scala.sequencing.computations.genericmodeling

object CanEquals {
  def main(args: Array[String]): Unit = {
    val cecil = new Animal(4, true)
    val bruce = new Dog(4, true, "Boxer")
    cecil.equals(bruce) // true
    bruce.equals(cecil) // false - cecil isn't a Dog!
  }
}

case class Animal(numLegs: Int, isCarnivore: Boolean) {
  override def equals(other: Any): Boolean =
    other match {
      case Animal(`numLegs`, isCarnivore) =>
        this.numLegs == numLegs &&
          this.isCarnivore == isCarnivore
      case _ => false
    }
}

class Dog(numLegs: Int, isCarnivore: Boolean, breed: String) extends Animal(numLegs, isCarnivore) {
  override def equals(other: Any): Boolean =
    other match {
      case that: Dog => true
      /*
              this.numLegs == that.numLegs &&
                this.isCarnivore == that.isCarnivore &&
                this.breed == that.breed
      */
      case _ => false
    }
}


package org.entu.essential.scala.patternmatching

import org.entu.essential.scala.caseclasses.Person

object Stormtropper {
  def main(args: Array[String]): Unit = {
    assert(inspect(Person("Luke", "Skywalker")) == "Stop, rebel scum!")
    assert(inspect(Person("Ann", "Smith")) == "Move along, Ann")
  }

  def inspect(person: Person): String =
    person match {
      case Person("Luke", "Skywalker") => "Stop, rebel scum!"
      case Person("Han", "Solo") => "Stop, rebel scum!"
      case Person(first, _) => s"Move along, $first"
    }
}

case class LastNameCaptor(firstName: String = "John", lastName: String = "Dee") {
  def matches: Boolean = true
}

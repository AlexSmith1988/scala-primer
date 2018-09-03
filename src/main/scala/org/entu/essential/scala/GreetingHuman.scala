package org.entu.essential.scala

/**
  * Define an object called person that contains fields called firstName and lastName.
  * Define a second object called alien containing a method called greet that takes
  * your person as a parameter and returns a greeting using their firstName.
  * What is the type of the greet method? Can we use this method to greet other objects?
  */

object Person {
  var firstName = ""
  var lastName = ""
}

object Alien {
  def greet(person: Person.type) = s"Greetings, ${person.firstName} ${person.lastName}"
}

object GreetingHuman {
  def main(args: Array[String]): Unit = {
    Person.lastName = "Doe"
    Person.firstName = "John"
    println(Alien.greet(Person))

  }
}


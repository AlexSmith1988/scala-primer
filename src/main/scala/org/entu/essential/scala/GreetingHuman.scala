package org.entu.essential.scala

/**
  * Define an object called person that contains fields called firstName and lastName.
  * Define a second object called alien containing a method called greet that takes
  * your person as a parameter and returns a greeting using their firstName.
  * What is the type of the greet method? Can we use this method to greet other objects?
  */


object Alien {
  def greet(person: Person) = s"Greetings, ${person.firstName} ${person.lastName}"
  def greet2console(person: Person): Unit = println(greet(person))
}

object GreetingHuman {
  def main(args: Array[String]): Unit = {
    Alien.greet2console(Person())
    val person = Person("Rick Sanchez")
    assert(person.firstName == "Rick")
    Alien.greet2console(person)
  }
}

class Person(val firstName: String = "John", val lastName: String = "Doe")

object Person {
  def apply(firstName: String = "John", lastName: String = "Doe"): Person
  = new Person(firstName, lastName)

  def apply(fullName: String): Person = {
    val nameParts = fullName.split(" ")
    Person(nameParts(0), nameParts(1))
  }
}


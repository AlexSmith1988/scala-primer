package org.entu.essential.scala.traits.modeling

object CakePatternSample extends App {
  println(s"${Borg.saying}, ${Borg.screaming}")
  println(s"${VolanDeMort.saying}, ${VolanDeMort.screaming}")
}

sealed trait Scream {
  def message: String

  def issue: String
}

sealed trait ExclamationScream extends Scream {
  def issue = s"!!!$message!!!"
}

sealed trait CapsScream extends Scream {
  def issue: String = message.toUpperCase
}

trait Speaker {
  self: Scream =>

  def saying: String = message

  def screaming: String = self.issue
}

/**
  * Cake pattern = dependency injection
  */
case object Borg extends Speaker with ExclamationScream {
  override def message: String = "Resistance is futile"
}

case object VolanDeMort extends Speaker with CapsScream {
  override def message: String = "Avada kedavra"
}
package org.entu.essential.scala.traits

import scala.util.Random

trait Pain {
  def intensity: Double
  def present: Boolean = {
    println(s"Intensity: $intensity")
    intensity > 0
  }
  def cure: Pain
  def cureIfPresent: Pain = if (present) cure.cureIfPresent else this
}

object HelloTraits extends App {
  HeadAche(20).cureIfPresent

}

case class HeadAche(intensity: Double) extends Pain {
  private def takePill = {
    println("Taken a pill")
    HeadAche(intensity - Random.nextDouble() * 10)
  }

  def cure: Pain = takePill
}

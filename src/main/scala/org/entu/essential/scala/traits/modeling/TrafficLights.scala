package org.entu.essential.scala.traits.modeling

object TrafficLights extends App {
  assert(Red.next == Green)
  assert(Green.next == Yellow)
  assert(Yellow.next == Red)

  assert(next(Red) == Green)
  assert(next(Green) == Yellow)
  assert(next(Yellow) == Red)

  def next(trafficLight: TrafficLight) =
    trafficLight match {
      case Red => Green
      case Green => Yellow
      case Yellow => Red
    }
}

sealed trait TrafficLight {
  def next: TrafficLight
}

case object Red extends TrafficLight {
  val next: Green.type = Green
}


case object Green extends TrafficLight {
  val next: Yellow.type = Yellow
}

case object Yellow extends TrafficLight {
  val next: Red.type = Red
}
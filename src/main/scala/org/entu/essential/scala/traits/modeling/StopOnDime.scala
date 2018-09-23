package org.entu.essential.scala.traits.modeling

object StopOnDime extends App {

  sealed trait TrafficLight

  final case object Red extends TrafficLight
  final case object Green extends TrafficLight
  final case object Yellow extends TrafficLight
}


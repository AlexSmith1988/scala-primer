package org.entu.katas

import scala.util.Random

object WeatherKata {

  def main(args: Array[String]): Unit = {
    println(Range.apply(1, 1000).map((_) => new Weather()))
  }
}

class Weather(snowing: Boolean = Random nextBoolean(),
              raining: Boolean = Random nextBoolean(),
              freezing: Boolean = Random nextBoolean(),
              windy: Boolean = Random nextBoolean())

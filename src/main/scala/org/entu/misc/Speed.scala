package org.entu.misc

import scala.collection.mutable

/**
  * Input:
  * multiple cars travel at some speed during some time interval.
  * Output:
  * for each interval give median speed.
  *
  * Example:
  * Car1 |-----50 kmh----/
  * Car2         /-----------------30 kmh------/
  * Res  /--50--/--40----/---30----------------/
  */
object Speed {

  def main(args: Array[String]): Unit = {

  }

  def average(intervals : List[CarInterval]) : mutable.Map[Int, Double] =
    new mutable.HashMap[Int, Double]()

}

class CarInterval(val start: Int, val length: Int, val speed: Double) {
  def apply(start: Int, length: Int, speed: Double): CarInterval =
    new CarInterval(start, length, speed)
}

class Point(val x: Double, val y: Double) {
  override def toString: String = s"($x, $y)"
}

object Point {
  def apply(x: Double, y: Double): Point = new Point(x, y)
}



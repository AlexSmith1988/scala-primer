package org.entu.essential.scala.traits

object Shapes extends App {
  println(Square(10).perimeter)
  assert(Square(10).perimeter == 40)
  assert(Square(10).square == 100)
  assert(Rectangle(10, 20).square == 200)
  assert(Rectangle(10, 20).perimeter == 60)
}

trait Shape {
  def sides: Int

  def perimeter: Double

  def square: Double
}

case class Circle(radius: Double) extends Shape {
  val sides = 1

  val perimeter: Double = 2 * math.Pi * radius

  val square: Double = math.Pi * radius * radius
}

trait Rectangular extends Shape {
  def width: Double

  def height: Double

  val sides = 4

  def perimeter: Double = 2 * (width + height)

  def square: Double = width * height
}

case class Rectangle(width: Double, height: Double) extends Rectangular

case class Square(size: Double) extends Rectangular {
  val width: Double = size

  val height: Double = size
}

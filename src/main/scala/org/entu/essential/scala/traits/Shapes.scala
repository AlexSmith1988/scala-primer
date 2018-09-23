package org.entu.essential.scala.traits

object Shapes extends App {
  assert(Square(10).perimeter == 40)
  assert(Square(10).square == 100)
  assert(Rectangle(10, 20).square == 200)
  assert(Rectangle(10, 20).perimeter == 60)

  assertShapes(Circle(10))
  assertShapes(Rectangle(10, 20))
  assertShapes(Square(10))

  assert("A yellow rectangle of width 5.0cm and height 7.0cm" == Draw(Rectangle(5, 7, Yellow)))
  assert("A pink rectangle of width 9.0cm and height 15.0cm" == Draw(Rectangle(9, 15, Pink)))
  assert("A dark circle of radius 12.0cm" == Draw(Circle(12, PickedColor(10, 24, 100))))
  assert("A light square of size 17.0cm" == Draw(Square(17, PickedColor(140, 42, 19))))

  def assertShapes(shape: Shape): Unit = {
    assert(shape.sides ==
      (shape match {
        case Circle(_, _) => 1
        case Rectangle(_, _, _) => 4
        case Square(_, _) => 4
      })
    )
  }
}

sealed trait Shape {
  def sides: Int

  def perimeter: Double

  def square: Double

  def color: Color
}

final case class Circle(radius: Double, color: Color = Red) extends Shape {
  val sides = 1

  val perimeter: Double = 2 * math.Pi * radius

  val square: Double = math.Pi * radius * radius
}

sealed trait Rectangular extends Shape {
  def width: Double

  def height: Double

  val sides = 4

  def perimeter: Double = 2 * (width + height)

  def square: Double = width * height
}

final case class Rectangle(width: Double, height: Double, color: Color = Red) extends Rectangular

final case class Square(size: Double, color: Color = Red) extends Rectangular {
  val width: Double = size

  val height: Double = size
}

object Draw {
  def apply(shape: Shape): String = s"A ${Draw(shape.color)} ${drawShape(shape)}"

  def apply(color: Color): String =
    color match {
      case Yellow => "yellow"
      case Pink => "pink"
      case Red => "red"
      case _ => if (color.isLight) "light" else "dark"
    }

  def drawShape(shape: Shape): String =
    shape match {
      case Circle(radius, _) => s"circle of radius ${radius}cm"
      case Rectangle(width, height, _) => s"rectangle of width ${width}cm and height ${height}cm"
      case Square(size, _) => s"square of size ${size}cm"
    }

}

sealed trait Color {
  def red: Int

  def green: Int

  def blue: Int

  def isLight: Boolean = red > 123 || green > 123 || blue > 123

  def isDark: Boolean = !isLight
}

sealed case class PickedColor(red: Int, green: Int, blue: Int) extends Color

object Red extends PickedColor(255, 0, 0)

object Yellow extends PickedColor(0, 255, 255)

object Pink extends PickedColor(255, 0, 100)

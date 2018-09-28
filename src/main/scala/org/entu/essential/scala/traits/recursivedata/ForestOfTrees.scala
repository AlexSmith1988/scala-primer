package org.entu.essential.scala.traits.recursivedata

object ForestOfTrees extends App {
  val tree = Leaf(Leaf(Node(4), Leaf(Leaf(Node(1), Node(2)), Node(3))), null)

  assert(sum(tree) == 10)
  assert(tree.sum == 10)

  assert(double(tree) == Leaf(Leaf(Node(8), Leaf(Leaf(Node(2), Node(4)), Node(6))), null))
  assert(tree.double == Leaf(Leaf(Node(8), Leaf(Leaf(Node(2), Node(4)), Node(6))), null))


  def sum(tree: Tree): Int = {
    tree match {
      case Node(element) => element
      case Leaf(left, right) => sum(left) + sum(right)
      case _ => 0
    }
  }

  def double(tree: Tree): Tree = {
    tree match {
      case Node(element) => Node(2 * element)
      case Leaf(left, right) => Leaf(double(left), double(right))
      case _ => null
    }
  }
}

sealed trait Tree {
  def sum: Int

  def double: Tree
}

final case class Leaf(left: Tree, right: Tree) extends Tree {
  override def sum: Int = {
    val ls = if (left == null) 0 else left.sum
    val rs = if (right == null) 0 else right.sum
    ls + rs
  }

  override def double: Tree =
    Leaf(
      if (left == null) null else left.double,
      if (right == null) null else right.double)
}

final case class Node(element: Int) extends Tree {
  val sum: Int = element
  lazy val double: Tree = Node(element * 2)
}


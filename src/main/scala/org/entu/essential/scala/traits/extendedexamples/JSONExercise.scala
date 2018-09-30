package org.entu.essential.scala.traits.extendedexamples


object JSONExercise {

  def main(args: Array[String]): Unit = {
    val sampleJson = SeqCell(
      SeqCell(JsString("a string"), SeqCell(JsNumber(1.0), SeqCell(True, SeqEnd))),
      SeqCell(
        ObjectCell("a", SeqCell(JsNumber(1), SeqCell(JsNumber(2), SeqCell(JsNumber(3), SeqEnd))),
          ObjectCell("b",
            SeqCell(JsString("a"),
              SeqCell(JsString("b"),
                SeqCell(JsString("c"), SeqEnd))),
            ObjectCell("c",
              ObjectCell("doh", True,
                ObjectCell("ray", False,
                  ObjectCell("me", JsNumber(1), ObjectEnd))), ObjectEnd))), SeqEnd))
    println(sampleJson)

    println(
      SeqCell(JsString("a string"), SeqCell(JsNumber(1.0), SeqCell(True, SeqEnd))).print)
    // res: String = ["a string", 1.0, true]

    println(
      ObjectCell(
        "a", SeqCell(JsNumber(1.0), SeqCell(JsNumber(2.0), SeqCell(JsNumber(3.0), SeqEnd))),
        ObjectCell(
          "b", SeqCell(JsString("a"), SeqCell(JsString("b"), SeqCell(JsString("c"), SeqEnd))),
          ObjectCell(
            "c", ObjectCell("doh", True,
              ObjectCell("ray", True,
                ObjectCell("me", JsNumber(1.0), ObjectEnd))),
            ObjectEnd
          )
        )
      ).print)
    // res: String = {"a": [1.0, 2.0, 3.0], "b": ["a", "b", "c"], "c": {"doh": true, "ray": false, "me": 1.0}}
  }
}

/**
  * Json ::= JsNumber value:Double
  * | JsString value:String
  * | JsBoolean value:Boolean
  * | JsNull
  * | JsSequence
  * | JsObject
  * JsSequence ::= SeqCell head:Json tail:JsSequence
  * | SeqEnd
  * JsObject ::= ObjectCell key:String value:Json tail:JsObject
  * | ObjectEnd
  */
sealed trait Json {
  def print: String = {
    this match {
      case JsNumber(value) => s"$value"
      case True => "true"
      case False => "false"
      case JsString(value) => s""""$value""""
      case jsSequence: JsSequence => s"[${printSequence(jsSequence, beginning = true)}]"
      case jsObject: JsObject => s"[${printObject(jsObject, beginning = true)}]"
      case JsNull => ""
    }
  }

  def printSequence(sequence: JsSequence, beginning: Boolean = false): String =
    sequence match {
      case SeqCell(head, tail@SeqCell(_, _)) => s"${head.print}, ${printSequence(tail)}"
      case SeqCell(head, SeqEnd) => s"${head.print}"
      case end => ""
    }

  def printObject(jsObject: JsObject, beginning: Boolean = false): String =
    jsObject match {
      case ObjectCell(key, value, tail@ObjectCell(_, _, _)) =>
        s"${quote(key)} : ${value.print}, ${printObject(tail)}"
      case ObjectCell(key, value, ObjectEnd) => s"${quote(key)} : ${value.print}"
      case end => ""
    }

  def quote(src: String): String = s""""$src""""
}

final case class JsNumber(value: Double) extends Json

final case class JsString(value: String) extends Json

sealed trait JsBool extends Json

case object True extends JsBool

case object False extends JsBool

case object JsNull extends Json

sealed trait JsSequence extends Json

final case class SeqCell(head: Json, tail: JsSequence) extends JsSequence

case object SeqEnd extends JsSequence

sealed trait JsObject extends Json

final case class ObjectCell(key: String, value: Json, tail: JsObject) extends JsObject

case object ObjectEnd extends JsObject
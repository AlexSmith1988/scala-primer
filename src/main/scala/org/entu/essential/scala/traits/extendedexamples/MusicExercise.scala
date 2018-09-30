package org.entu.essential.scala.traits.extendedexamples

/**
  * What is music? Music is pleasant non-verbal sounds.
  * Birds chirping is not music, human singing also is not music.
  * Water droplets are music, playing on ones lip is music.
  * Bird hitting the wood with it's beak can be music.
  *
  * Types of voices
  * An amount of each voice
  * Each voice has tracks
  * Each track contains frequency and duration
  *
  * Music ::= Voice Music | Silence
  * Voice ::= Properties Instances
  * Properties ::= key:String value:String Properties | End
  * Instances ::= Tracks Instances | End
  * Tracks ::= Track Tracks | End
  * Track ::= frequency:Double start:Double duration:Double volume:Double Track | End
  * frequency == 0 | volume == 0 => silence
  */
object MusicExercise {

}


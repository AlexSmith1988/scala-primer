package org.entu.essential.scala.caseclasses

object DirectorialDebut {
  def main(args: Array[String]): Unit = {
    val eastwood = Director("Clint", "Eastwood", 1930)
    val mcTiernan = Director("John", "McTiernan", 1951)
    val nolan = Director("Christopher", "Nolan", 1970)
    val someBody = Director("Just", "Some Body", 1990)
    val memento = Film("Memento", 2000, 8.5, nolan)
    val darkKnight = Film("Dark Knight", 2008, 9.0, nolan)
    val inception = Film("Inception", 2010, 8.8, nolan)
    val highPlainsDrifter = Film("High Plains Drifter", 1973, 7.7, eastwood)
    val outlawJoseyWales = Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
    val unforgiven = Film("Unforgiven", 1992, 8.3, eastwood)
    val granTorino = Film("Gran Torino", 2008, 8.2, eastwood)
    val invictus = Film("Invictus", 2009, 7.4, eastwood)
    val predator = Film("Predator", 1987, 7.9, mcTiernan)

    val dieHard = Film("Die Hard", 1988, 8.3, mcTiernan)
    val huntForRedOctober = Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
    val thomasCrownAffair = Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

    assert(eastwood.yearOfBirth == 1930)
    assert(dieHard.director.name == "John McTiernan")
    assert(!invictus.isDirectedBy(nolan))

    println(highPlainsDrifter.copy(name = "L'homme des hautes plaines"))
    println(thomasCrownAffair.copy(yearOfRelease = 1968, director =
      Director("Norman", "Jewison", 1926)))

    assert(Film.highestRating(huntForRedOctober, dieHard) == dieHard)
    println("Extended body of work")
    println(highPlainsDrifter.directorsAge)
    println(huntForRedOctober.directorsAge)
    println(thomasCrownAffair.directorsAge)
    assert(Film.oldestDirectorAtTheTime(highPlainsDrifter, thomasCrownAffair) == thomasCrownAffair)
  }
}

case class Director(firstName: String, lastName: String, yearOfBirth: Int) {
  def name = s"$firstName $lastName"
}

case class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {
  def directorsAge: Int = yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director): Boolean = director == this.director
}

object Director {
  def older(first: Director, second: Director): Director =
    if (first.yearOfBirth > second.yearOfBirth) first else second

}

object Film {
  def highestRating(first: Film, second: Film): Film =
    if (first.imdbRating > second.imdbRating) first else second

  def oldestDirectorAtTheTime(first: Film, second: Film): Film =
    if (first.directorsAge > second.directorsAge) first else second
}


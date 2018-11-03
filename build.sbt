name := "scala-primer"

version := "0.1"

scalaVersion := "2.12.6"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.3")

// https://mvnrepository.com/artifact/org.agrona/agrona
libraryDependencies += "org.agrona" % "agrona" % "0.9.5"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" /*% "test"*/
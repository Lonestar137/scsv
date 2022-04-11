import Dependencies._
import sbt.Keys.libraryDependencies

ThisBuild / scalaVersion     := "2.11.12"
ThisBuild / version          := "Build-0.1.0"
ThisBuild / organization     := "com.revature"
ThisBuild / organizationName := "revature"
ThisBuild / logLevel := Level.Error

lazy val root = (project in file("."))
  .settings(
    name := "slick-java",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.postgresql" % "postgresql" % "42.3.3",
    libraryDependencies += "org.apache.hive" % "hive-jdbc" % "3.1.2",
    libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.10",
  )
// NOTE: .settings appends certain ThisBuild / variables to the URI which makes it not work with some dependencies.
// The below dependency is an example of such behavior.
// SOURCE: https://search.maven.org/artifact/com.googlecode.lanterna/lanterna/3.1.1/jar

//libraryDependencies += "com.googlecode.lanterna" % "lanterna" % "3.1.1"


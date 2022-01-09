lazy val scala213 = "2.13.7"
lazy val scala212 = "2.12.15"
lazy val scala211 = "2.11.12"

ThisBuild / version := "0.5.0"
ThisBuild / scalaVersion := scala213
crossScalaVersions := Seq(scala213)
lazy val root = (project in file("."))
  .settings(
    name := "scala-mediator",
    idePackagePrefix := Some("minze25.scalamediator")
  )
libraryDependencies += "org.reflections" % "reflections" % "0.10.2"
libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
libraryDependencies += "net.codingwell" %% "scala-guice" % "5.0.2"


ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.7"

lazy val root = (project in file("."))
  .settings(
    name := "scala-mediator",
    idePackagePrefix := Some("minze25.scalamediator")
  )
libraryDependencies += "org.reflections" % "reflections" % "0.10.2"
libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
libraryDependencies += "net.codingwell" %% "scala-guice" % "5.0.2"


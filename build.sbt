lazy val scala213 = "2.13.7"
lazy val scala212 = "2.12.15"
lazy val scala211 = "2.11.12"
organization := "io.github.minze25"
ThisBuild / version := "0.6.0"
ThisBuild / scalaVersion := scala213
ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org"

crossScalaVersions := Seq(scala213)
lazy val root = (project in file("."))
  .settings(
    name := "scala-mediator",
    idePackagePrefix := Some("io.github.minze25.scalamediator")
  )
libraryDependencies += "org.reflections" % "reflections" % "0.10.2"
libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
libraryDependencies += "net.codingwell" %% "scala-guice" % "5.0.2"
publishTo := sonatypePublishToBundle.value

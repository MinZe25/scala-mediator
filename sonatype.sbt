import xerial.sbt.Sonatype._

sonatypeProfileName := "io.github.minze25"
licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))
sonatypeProjectHosting := Some(GitHubHosting("minze25", "scala-mediator", "bbminze@gmail.com"))
publishMavenStyle := true

scmInfo := Some(
  ScmInfo(
    url("https://github.com/MinZe25/scala-mediator"),
    "scm:git@github.com:MinZe25/scala-mediator.git"
  )
)
developers := List(
  Developer(id = "minze25", name = "Aitor Garcia Diez", email = "bbminze@gmail.com", url = url("https://github.com/MinZe25/"))
)

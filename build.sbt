enablePlugins(ScalaJSPlugin)


libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.4" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"
libraryDependencies += "com.lihaoyi" %%% "pprint" % "0.5.3"

import scala.sys.process._
val copy = taskKey[Unit]("")
val copyProd = taskKey[Unit]("")
copy := { "cp target\\scala-2.12\\ctranspiler-fastopt.js ..\\www\\hugo\\static\\js" ! }
copyProd := { "cp target\\scala-2.12\\ctranspiler-opt.js ..\\www\\hugo\\static\\js" ! }


// TODO relative paths
lazy val CParser = ProjectRef(file("../CParser"), "cparser")

lazy val CParserWebDemo = (project in file("."))
  .settings(
    name := "CParserWebDemo",
    scalaVersion := "2.12.4"
  ).dependsOn(CParser)

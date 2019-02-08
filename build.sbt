name := "ganskedanske"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.6"
libraryDependencies += "com.github.japgolly.scalajs-react" %%% "core" % "1.4.0"

enablePlugins(ScalaJSPlugin)
enablePlugins(ScalaJSBundlerPlugin)

npmDependencies in Compile ++= Seq(
  "react" -> "16.7.0",
  "react-dom" -> "16.7.0")

// This is an application with a main method
scalaJSUseMainModuleInitializer := true
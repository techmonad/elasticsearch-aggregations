name := "elasticsearch-aggregations"

version := "0.1"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "org.elasticsearch" % "elasticsearch" % "2.4.4",
  "com.typesafe" % "config" % "1.3.1"
)
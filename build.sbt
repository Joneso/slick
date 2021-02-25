name := "slick"

version := "0.1"

scalaVersion := "2.12.13"

libraryDependencies ++= Seq(
  "mysql"   %  "mysql-connector-java"  % "8.0.22",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.typesafe.slick" %% "slick" % "3.3.3",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3",
)
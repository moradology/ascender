name := "ascender"

scalaVersion := Version.scala

lazy val commonSettings = Seq(
  organization := "holodeck",
  version := Version.ascender,
  cancelable in Global := true,
  scalaVersion := Version.scala,
  scalacOptions := Seq(
    "-deprecation",
    "-unchecked",
    "-feature",
    "-language:implicitConversions",
    "-language:reflectiveCalls",
    "-language:higherKinds",
    "-language:postfixOps",
    "-language:existentials",
    "-language:experimental.macros",
    "-feature"
  ),
  resolvers += Resolver.sonatypeRepo("snapshots"),
  shellPrompt := { s => Project.extract(s).currentProject.id + " > " }
)

lazy val appSettings = commonSettings ++ Seq(
  fork in run := true,
  connectInput in run := true,
  cancelable in Global := true,
  assemblyJarName in assembly := "ascender-server.jar",
  assemblyMergeStrategy in assembly := {
    case "reference.conf" => MergeStrategy.concat
    case "application.conf" => MergeStrategy.concat
    case n if n.endsWith(".SF") || n.endsWith(".RSA") || n.endsWith(".DSA") => MergeStrategy.discard
    case "META-INF/MANIFEST.MF" => MergeStrategy.discard
    case _ => MergeStrategy.first
  },
  resolvers += Resolver.bintrayRepo("hseeberger", "maven"),
  test in assembly := {}
)
lazy val loggingDependencies = List(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
  "ch.qos.logback" %  "logback-classic" % "1.1.7"
)

lazy val dbDependencies = List(
  Dependencies.hikariCP,
  Dependencies.postgres
)

lazy val migrationsDependencies =
  dbDependencies ++ loggingDependencies

lazy val testDependencies = List(
    Dependencies.scalatest
)

lazy val appDependencies = dbDependencies ++ migrationsDependencies ++
    testDependencies ++ Seq(
  Dependencies.akka,
  Dependencies.akkahttp,
  Dependencies.akkajson,
  Dependencies.akkaHttpCors,
  Dependencies.akkastream,
  Dependencies.akkaSlf4j,
  Dependencies.commonsIO,
  Dependencies.circeCore,
  Dependencies.circeGeneric,
  Dependencies.circeParser
)

lazy val root = Project("root", file("."))
  .aggregate(app, datamodel)
  .settings(commonSettings:_*)

lazy val app = Project("app", file("app"))
  .dependsOn(datamodel)
  .settings(appSettings:_*)
  .settings({
    libraryDependencies ++= appDependencies
  })

lazy val datamodel = Project("datamodel", file("datamodel"))
  .settings(commonSettings:_*)
  .settings({libraryDependencies ++= testDependencies ++ Seq(
    Dependencies.commonsIO,
    Dependencies.circeCore,
    Dependencies.circeGeneric,
    Dependencies.circeParser
  )})

lazy val common = Project("common", file("common"))
  .settings(appSettings:_*)
  .settings({libraryDependencies ++= testDependencies ++ Seq(
    Dependencies.akka,
    Dependencies.akkahttp,
    Dependencies.commonsIO
  )})


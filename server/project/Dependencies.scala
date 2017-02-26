import scala.util.Properties

import sbt._

object Dependencies {
  val akka         = "com.typesafe.akka" %% "akka-actor"           % Version.akka
  val akkahttp     = "com.typesafe.akka" %% "akka-http"            % Version.akkaHttp
  val akkajson     = "de.heikoseeberger" %% "akka-http-circe"      % Version.akkaHttpCirce
  val akkatestkit  = "com.typesafe.akka" %% "akka-http-testkit"    % Version.akkaHttp
  val akkastream   = "com.typesafe.akka" %% "akka-stream"          % Version.akka
  val akkaSlf4j    = "com.typesafe.akka" %% "akka-slf4j"           % Version.akkaSlf4j
  val hikariCP     = "com.typesafe.slick"%% "slick-hikaricp"       % Version.hikariCP
  val postgres     = "org.postgresql"     % "postgresql"           % Version.postgres
  val scalatest    = "org.scalatest"     %% "scalatest"            % Version.scalaTest % "test"
  val slf4j        = "org.slf4j"          % "slf4j-simple"         % Version.slf4j
  val akkaHttpCors = "ch.megard"         %% "akka-http-cors"       % Version.akkaHttpCors
  val commonsIO    = "commons-io"         % "commons-io"           % Version.commonsIO
  val scopt        = "com.github.scopt"  %% "scopt"                % Version.scopt
  val shapeless    = "com.chuusai"       %% "shapeless"            % Version.shapeless
  val circeCore    = "io.circe"          %% "circe-core"           % Version.circe
  val circeGeneric = "io.circe"          %% "circe-generic"        % Version.circe
  val circeParser  = "io.circe"          %% "circe-parser"         % Version.circe
}

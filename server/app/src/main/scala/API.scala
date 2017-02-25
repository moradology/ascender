package holodeck.ascender.app

import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._

import ch.megard.akka.http.cors.CorsDirectives._
import ch.megard.akka.http.cors.CorsSettings

object API {

  val climbingRoutes = cors() {
    pathPrefix("route") {
      pathEndOrSingleSlash {
        complete("hey")
      }
    }
  }




}

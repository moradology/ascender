package holodeck.ascender.app

import java.util.UUID
import java.time.LocalDateTime

import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import ch.megard.akka.http.cors.CorsDirectives._
import ch.megard.akka.http.cors.CorsSettings
import de.heikoseeberger.akkahttpcirce.CirceSupport
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._

import holodeck.ascender.datamodel._

object API extends CirceSupport {
  val climbingRoutes = cors() {
    pathPrefix("route") {
      pathEndOrSingleSlash {
       complete(Climb(UUID.randomUUID(), "Our Climb", LocalDateTime.now(), LocalDateTime.now()).asJson)
      }
    }
  }
}

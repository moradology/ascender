package holodeck.ascender

import java.util.UUID
import java.time.LocalDateTime

import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._

package object app {

  implicit val uuidEncoder = new Encoder[UUID] {
    final def apply(uuid: UUID): Json = uuid.toString.asJson
  }

  implicit val uuidDecoder: Decoder[UUID] =
    Decoder[String].map { str =>
      UUID.fromString(str)
    }

  implicit val dateTimeEncoder = new Encoder[LocalDateTime] {
    final def apply(dt: LocalDateTime): Json = dt.toString.asJson
  }

  implicit val dateTimeDecoder: Decoder[LocalDateTime] =
    Decoder[String].map { str =>
      LocalDateTime.parse(str)
    }
}

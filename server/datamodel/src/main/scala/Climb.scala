package holodeck.ascender.datamodel

import java.util.UUID
import java.time.LocalDateTime

import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._


case class Climb(
  id: UUID = UUID.randomUUID(),
  name: String = "TESTING",
  created: LocalDateTime = LocalDateTime.now(),
  modified: LocalDateTime = LocalDateTime.now()
)


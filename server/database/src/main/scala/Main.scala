package holodeck.ascender.database

import java.time.LocalDateTime
import java.util.UUID
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration._

import io.getquill._
import io.getquill.context.async.Decoders

import holodeck.ascender.datamodel._

object Main extends App {
  lazy val ctx = new PostgresAsyncContext[SnakeCase]("db.default") with ImplicitQuery

  import ctx._

  val test = quote {
    query[Climb].insert(lift(Climb()))
  }

  val x = Await.result(ctx.run(test), 10 seconds)
  println(x)
}

package models
import play.api.libs.json._

case class Team(id: Long, name: String, description: String)

object Team {
  implicit val implicitTeamWrites = new Writes[Team] {
    def writes(c: Team): JsValue = {
      Json.obj(
        "id" -> c.id,
        "name" -> c.name,
        "description" -> c.description
      )
    }
  }
  implicit val json = Json.format[Team]
}

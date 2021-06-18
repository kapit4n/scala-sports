package controllers

import javax.inject._

import play.api.libs.json.Json
import play.api.mvc._
import play.api.libs.json._
import play.api.data.Forms._
import play.api.data.Form
import play.api.data._

case class Team(var name: String, var description: String)

case class TeamForm(name: String, description: String)

object Team {
  implicit val implicitTeamWrites = new Writes[Team] {
    def writes(c: Team): JsValue = {
      Json.obj(
        "name" -> c.name,
        "description" -> c.description
      )
    }
  }
}

@Singleton
class TeamController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  val teamForm: Form[TeamForm] =  Form {
    mapping(
      "name" -> text,
      "description"  -> text
    )(TeamForm.apply)(TeamForm.unapply)
  }

  def list = Action {
    Ok(Json.toJson(Seq(Team("Barcelona", "gg"), Team("Real Madrid", "jj"))))
  }

  def create = Action { implicit request =>
    val teamData = teamForm.bindFromRequest.get
    Ok(Json.obj("result" -> teamData.toString))
  }

  def update(id: Int) =  Action { implicit request => 
    val teamData = teamForm.bindFromRequest.get
    Ok(Json.obj("result" -> teamData.toString))
  }

  def delete(id: Int) =  Action { 
    Ok(Json.obj("result" -> s"Delete ${id}"))
  }
}

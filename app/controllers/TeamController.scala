package controllers

import dal.TeamDAO

import javax.inject._
import play.api.libs.json.Json
import play.api.mvc._
import play.api.libs.json._
import play.api.data.Forms._
import play.api.data.Form
import play.api.data._
import models._

import scala.concurrent.ExecutionContext

case class TeamForm(name: String, description: String)

@Singleton
class TeamController @Inject()(cc: ControllerComponents, teamDao: TeamDAO)(implicit ec: ExecutionContext) extends AbstractController(cc) {
  val teamForm: Form[TeamForm] =  Form {
    mapping(
      "name" -> text,
      "description"  -> text
    )(TeamForm.apply)(TeamForm.unapply)
  }

  def list = Action.async {
    teamDao.all().map{ res =>
      Ok(Json.toJson(res))
    }
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

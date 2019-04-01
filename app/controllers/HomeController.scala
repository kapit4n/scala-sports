package controllers

import javax.inject._

import play.api.libs.json.Json
import play.api.mvc._
import play.api.libs.json._

case class Customer(var id: Int, var name: String)

object Customer {
  implicit val implicitCustomerWrites = new Writes[Customer] {
    def writes(c: Customer): JsValue = {
      Json.obj(
        "id" -> c.id,
        "name" -> c.name
      )
    }
  }
}

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def appSummary = Action {
    Ok(Json.obj("content" -> "Scala Play Angular Seed"))
  }

  def customerList = Action {
    Ok(Json.toJson(Seq(Customer(1, "Luis"), Customer(1, "Hansel"))))
  }

  def postTest = Action {
    Ok(Json.obj("content" -> "Post Request Test => Data Sending Success"))
  }
}

package dal

import scala.concurrent.{ ExecutionContext, Future }
import javax.inject.Inject

import models.Team
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.SQLiteProfile.api._ // must impor
import slick.jdbc.SQLiteProfile
class TeamDAO @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[SQLiteProfile] {

  private val Teams = TableQuery[TeamsTable]

  def all(): Future[Seq[Team]] = db.run(Teams.result)

  def insert(cat: Team): Future[Unit] = db.run(Teams += cat).map { _ => () }

  private class TeamsTable(tag: Tag) extends Table[Team](tag, "teams") {

    def id = column[Long]("id", O.PrimaryKey)
    def name = column[String]("name", O.PrimaryKey)
    def description = column[String]("description")

    def * = (id, name, description) <> ((Team.apply _).tupled, Team.unapply)
  }
}
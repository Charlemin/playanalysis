package dao

import model.SlickTables.{TagsUp, UserTagsUp}
import play.api.{Play, db}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfig}
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.lifted

import scala.concurrent.Future

class UserTagsUpDao() extends HasDatabaseConfig[JdbcProfile]{

  protected lazy val dbConfig: DatabaseConfig[JdbcProfile] = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  import driver.api._
  val UserTags = TableQuery[UserTagsUp]

  def allTags(): Future[Seq[TagsUp]] =
    db.run(UserTags.sortBy(_.id.desc).take(10).result)

}

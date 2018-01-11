package model

import play.api.Play
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfig}
import slick.driver.JdbcProfile

object SlickTables extends HasDatabaseConfig[JdbcProfile]{

  protected lazy val dbConfig =
    DatabaseConfigProvider.get[JdbcProfile](Play.current)

  import dbConfig.driver.api._

  type TagsUp = (Int, String, String, String, Int, String)
  class UserTagsUp(tag: Tag) extends Table[(TagsUp)](tag, "user_tags_up") {
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def tagName = column[String]("tag")
    def types = column[String]("type")
    def upid = column[Int]("upid", O.Default(0))
    def values = column[String]("values")
    def * = (id, name, tagName, types, upid, values)
  }
}


package dao

import slick.jdbc.MySQLProfile.api._
import res.dbConfig._

import scala.concurrent.Future
object userInfoDao {
  import model.UserInfo
  class userTable(tag: Tag) extends Table[UserInfo](tag, "userInfo"){
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def age = column[Int]("age")
    def * = (id, name, age) <> ((UserInfo.apply _).tupled, UserInfo.unapply)
  }
  def user_table = TableQuery[userTable]

  def findById(id:Long):Future[Seq[UserInfo]] = db.run(user_table.filter(_.id === id ).result)
  def updateAgeById(id:Long, age:Int) = db.run(user_table.filter(user =>user.id === id).
    map(_.age).update(age)
  )
}

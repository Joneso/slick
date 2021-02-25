package dao

import slick.jdbc.MySQLProfile.api._

object userInfoDao {
  import model.UserInfo
  class userTable(tag: Tag) extends Table[UserInfo](tag, "userInfo"){
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def age = column[Int]("age")
    def * = (id, name, age) <> ((UserInfo.apply _).tupled, UserInfo.unapply)
  }
  def user_table = TableQuery[userTable]
}

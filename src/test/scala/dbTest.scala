import java.io.File

import model.UserInfo
import org.slf4j.LoggerFactory
import slick.jdbc.MySQLProfile.api._
import dao.userInfoDao._
import res.dbConfig._

import scala.concurrent.Await
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
object dbTest  extends  App {
  val logger = LoggerFactory.getLogger(getClass.getSimpleName)

//  val random = new scala.util.Random()
//  val user1 = UserInfo(1, "Jonas", 28)
//  val user2 = UserInfo(2, "Elena", 25)
//  val user3 = UserInfo(3, "Enoch", 18)
//  val users = List(user1, user2,user3)
//
//  val insertResult = db.run(user_table ++= users)
//
//  insertResult.onComplete{
//    case Success(ok) => println(ok)
//    case Failure(exception) => println("error")
//  }

  val selectorResult = updateAgeById(2,25).flatMap(_=> findById(2))
  selectorResult.onComplete{
    case Success(ok) => println(ok.toString())
    case Failure(exception) =>println(exception.getMessage)
  }
  Thread.sleep(10000)
}
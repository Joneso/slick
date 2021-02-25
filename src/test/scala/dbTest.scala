import java.io.File

import com.typesafe.config.ConfigFactory
import model.UserInfo
import org.slf4j.LoggerFactory
import slick.jdbc.MySQLProfile.api._
import dao.userInfoDao._
import scala.concurrent.Await
import scala.util.{Failure, Success}
object dbTest  extends  App {
  val logger = LoggerFactory.getLogger(getClass.getSimpleName)

  val file = new File("D:\\self-practice\\slick\\slickFirst\\conf\\database.conf")
  val config = ConfigFactory.parseFile(file)
  val db = Database.forConfig("mysql_db",config.getConfig("db"))

  val random = new scala.util.Random()
  val user1 = UserInfo(1, "Jonas", 28)
  val user2 = UserInfo(2, "Elena", 25)
  val user3 = UserInfo(3, "Enoch", 18)
  val users = List(user1, user2,user3)

//  val insertResult = Await.result(db.run(user_table ++= users),Duration.Inf)
//  println(insertResult)
  val insertResult = db.run(user_table ++= users)
  import  scala.concurrent.ExecutionContext.Implicits.global
  insertResult.onComplete{
    case Success(ok) => println(ok)
    case Failure(exception) => println("error")
  }
  Thread.sleep(10000)
}

package res

import java.io.File

import com.typesafe.config.ConfigFactory
import slick.jdbc.MySQLProfile.api._

object dbConfig {
  private val file = new File("D:\\self-practice\\slick\\slickFirst\\conf\\database.conf")
  private val config = ConfigFactory.parseFile(file)
  val db = Database.forConfig("mysql_db",config.getConfig("db"))
}

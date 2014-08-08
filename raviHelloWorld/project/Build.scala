import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "raviHelloWorld"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    jdbc,
    // Add your project dependencies here,
    //"sqlite3" % "org.sqlite.JDBC" % "3.6.20",
    javaCore,
    javaEbean
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}

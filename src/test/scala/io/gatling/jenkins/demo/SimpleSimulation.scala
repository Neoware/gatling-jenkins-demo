package io.gatling.jenkins.demo

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class SimpleSimulation extends Simulation {

  val httpProtocol =
    http.baseURL("http://computer-database.gatling.io")

  val scn = scenario("Simple")
    .exec(
      http("Home").get("/"))

  setUp(
    scn.inject(
      constantUsersPerSec(10) during(15 seconds)))
    .protocols(httpProtocol)
}

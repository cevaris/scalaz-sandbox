package com.cevaris.models

import scalaz._, Scalaz._
import scalaz.Validation
import scalaz.stream._
import scalaz.concurrent._


case class Company(
  name: String,
  employeeCount: Int,
  maturity: Company.MaturityState,
  stockState: Company.TradingState,
  annualRevenue: Option[Double],
  domain: Set[Company.Domain]
)

object Company {
  sealed trait MaturityState
  case class Startup extends MaturityState
  case class Mature extends MaturityState

  trait TradingState
  case class Public extends TradingState
  case class Private extends TradingState

  sealed trait Domain
  case class Technology extends Domain
  case class Advertising extends Domain
  case class PublicRelations extends Domain
  case class HealthCare extends Domain
}

// val c0 = Company("MeanSaaS", 10, Startup, Private, Some(10000), Advertising)
// val c1 = Company(name="MeanSaaS", employeeCount=10, maturity=Startup, stockState=Private, annualRevenue=Some(10000), domain=Advertising)

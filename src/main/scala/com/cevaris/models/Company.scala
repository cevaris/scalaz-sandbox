package com.cevaris.models

import scalaz._, Scalaz._
import scalaz.Validation
import scalaz.stream._
import scalaz.concurrent._

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

  sealed trait Company
  case class Compnay(
    name: String,
    employeeCount: Int,
    maturity: MaturityState,
    stockState: TradingState,
    revenue: Option[Double],
    domain: Set[Domain]
  ) extends Company

}

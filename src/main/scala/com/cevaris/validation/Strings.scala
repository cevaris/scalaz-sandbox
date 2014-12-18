package com.cevaris.validation

import scalaz._, Scalaz._
import scalaz.Validation
import scalaz.stream._
import scalaz.concurrent._

object Strings {

  sealed trait NumError
  case class InvalidList(s: String)
  case class NumberNotEven(s: String) extends NumError

  val zeroTo100i: Process[Task, Int] = Process.range(0,100)

  def splitStringBy(delimeter: String)(s: String): List[String] = s.split(delimeter).toList
  def splitBySpace(s: String): List[String] = splitStringBy(" ")(s)
  def splitByComma(s: String): List[String] = splitStringBy(",")(s)
  def splitByTab(s: String): List[String] = splitStringBy("\t")(s)

  def parseList[A](parser: (String => A))(s: String): List[A] = splitBySpace(s).map(parser)
      
  def parseVal[A](parser: (String => Validation[NumberFormatException, A]))(s: String): Validation[NumberFormatException, A] = parser(s)

  def isEven(n: Int): Validation[NumError, Int] = n % 2 == 0 match {
    case true  => Success(n)
    case false => Failure(NumberNotEven(n.toString))
  }

}



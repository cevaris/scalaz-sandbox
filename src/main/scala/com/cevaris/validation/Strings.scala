package com.cevaris.validation

import scalaz._, Scalaz._
import scalaz.Validation

object Strings {

  sealed trait NumError
  case class InvalidList(s: String)
  case class NumberNotEven(s: String) extends NumError

  def splitString(s: String): List[String] = s.split(" ").toList

  def parseList[A](s: String, parser: (String => A)): ValidationNel[String, List[A]] = {
    val splitted = splitString(s)
    splitted.map(parser).successNel[String]
  }

  def parseVal(s: String): Option[Int] = parseInt(s) match {
    case Success(a) => Some(a)
    case Failure(e) => None
  }

  def isEven(n: Int): Validation[NumError, Int] = n % 2 == 0 match {
    case true  => Success(n)
    case false => Failure(NumberNotEven(n.toString))
  }

}



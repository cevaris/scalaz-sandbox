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
  
  def splitString(s: String): List[String] = s.split(" ").toList

  def parseList[A](parser: (String => A))(s: String): ValidationNel[NumError, List[A]] =
    splitString(s).map(parser).successNel[NumError]

  // def parseList[A](s: String, parser: (String => A)): ValidationNel[NumError, List[A]] =
  //   splitString(s).map(parser).successNel[NumError]
    
  def parseVal(s: String): Option[Int] = parseInt(s) match {
    case Success(a) => Some(a)
    case Failure(e) => None
  }

  def isEven(n: Int): Validation[NumError, Int] = n % 2 == 0 match {
    case true  => Success(n)
    case false => Failure(NumberNotEven(n.toString))
  }

}



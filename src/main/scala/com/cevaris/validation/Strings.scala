package com.cevaris.validation

import scalaz._, Scalaz._
import scalaz.Validation
import scalaz.stream._
import scalaz.concurrent._

object Strings {

  sealed trait StringsError
  case class InvalidList(s: String) extends StringsError
  case class NumberNotEven(s: String) extends StringsError
  case class InvalidLettersList(s: String) extends StringsError

  val zeroTo100i: Process[Task, Int] = Process.range(0,100)

  def splitStringBy(delimeter: String)(s: String): List[String] = s.split(delimeter).toList
  def splitBySpace(s: String): List[String] = splitStringBy(" ")(s)
  def splitByComma(s: String): List[String] = splitStringBy(",")(s)
  def splitByTab(s: String): List[String] = splitStringBy("\t")(s)

  def parseList[A](parser: (String => A))(s: String): List[A] = splitBySpace(s).map(parser)
      
  def parseVal[A](parser: (String => Validation[NumberFormatException, A]))(s: String): Validation[NumberFormatException, A] = parser(s)

  def isChar(c: Char): Boolean =
    isChar(c.toInt)
  def isChar(ci: Int): Boolean =
    (ci >= 65 && ci <= 90) || (ci >= 97 && ci <= 122)

  // def parseLettersSum(sc: String): Validation[String,Int] = {
  //   val ls = sc.filter(x => isChar(x))
  //   if(ls.length == sc.length){
  //     Success(ls.sum)
  //   } else {
  //     Failure(s"Failed to parse $sc")
  //   }
  // }

  def parseLettersSum(sc: String): StringsError \/ Int = {
    val ls = sc.filter(isChar _)
    println(ls)
    if(ls.length == sc.length){
      \/-(ls.sum)
    } else {
      -\/(Strings.InvalidLettersList(sc))
    }
  }

  def isEven(n: Int): Validation[StringsError, Int] = n % 2 == 0 match {
    case true  => Success(n)
    case false => Failure(NumberNotEven(n.toString))
  }

}



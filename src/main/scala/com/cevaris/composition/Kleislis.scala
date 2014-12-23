package com.cevaris.compositiion

import scalaz._
import Scalaz._

object Composer {
  
  import scalaz.Kleisli._


  // val square = Kleisli { (x: Int) => (x*x).some }
  // val half = Kleisli { (x: Int) => (x/2.0).some }
  // def addN(n: Int) = Kleisli { (x: Int) => (x + n).some }
  // def divN(n: Int) = Kleisli {
  //   (x: Int) => x match {
  //     case 0 => None
  //     case v => (x / n).some
  //   }
  // }

  // def multN(n: Int) = //Kleisli {  (x: Int) => x
  //   n match {
  //     case 0 => "Cannot divide by zero".failure
  //     case v => (10 / n).success
  //   }
  // //}

  // def test1r(x:Int) = x.some >>= (square >=> half)
  // def test1l(x:Int) = x.some >>= (half <=< square)

  // def test2r(x:Int) = x.some >>= (addN(2) >=> addN(5))
  // def test2l(x:Int) = x.some >>= (addN(2) <=< addN(5))

  // def test3r(x:Int) = x.some >>= (divN(2) >=> addN(5))
  // def test3l(x:Int) = x.some >>= (divN(2) <=< addN(5))

  


  def square(x: Int): Option[Double] = Some(x * x)
  def half(x: Double): Option[Double] = Some(x / 2)
  def stringVal(x: Double): Option[String] =
    if(x % 2 == 0.0) None
    else Some(x.toString)

  def parseVal(s: String): Option[Float] = Some(s.toFloat)

  def test1(x: Int) =
    for {
      a <- square(x)
      b <- half(a)
      c <- stringVal(b)
      d <- parseVal(c)
    } yield d

  val test2 = kleisli(square _) >=> kleisli(half _) >=> kleisli(stringVal _) >=> kleisli(parseVal _)



  // def str(x: Int): Option[String] = Some(x.toString)
  // def toInt(x: String): Option[Int] = Some(x.toInt)
  // def double(x: Int): Option[Double] = Some(x * 2)

  // // Lets compose those functions Ye Olde Way
  // def oldSchool(i: Int) =
  //   for (x <- str(i);
  //     y <- toInt(x);
  //     z <- double(y))
  //   yield z

  // // Kleisli!
  //   val funky = kleisli(str _) >=> (toInt _) >=> (double _)

}

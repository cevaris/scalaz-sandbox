import scalaz._, Scalaz._

object Num {

  sealed trait NumError
  case class NumberNotEven(s: String) extends NumError

  def parseVal(s: String): Option[Int] = parseInt(s) match {
    case Success(a) => Some(a)
    case Failure(e) => None
  }

  def isEven(n: Int): Validation[NumError, Int] = n % 2 == 0 match {
    case true  => Success(n)
    case false => Failure(NumberNotEven(n.toString))
  }

}



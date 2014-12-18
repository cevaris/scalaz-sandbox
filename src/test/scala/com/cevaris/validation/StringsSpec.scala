package com.cevaris.validation

import scalaz._, Scalaz._

import org.specs2.scalaz.DisjunctionMatchers._
import org.specs2.scalaz.ValidationMatchers._
import org.scalacheck._
import org.scalacheck.Prop.forAll

import com.cevaris.SpecTest


class StringsSpec extends SpecTest {

  val parseValInts = forAll { (a: Int) =>
    Strings.parseVal(parseInt)(a.toString) mustEqual Success(a)
  }
  val parseValDoubles = forAll { (a: Double) =>
    Strings.parseVal(parseDouble)(a.toString) mustEqual Success(a)
  }

  "Strings object" should {
    "properly detect if isEven" in {
      Strings.isEven(2) must beSuccessful
      Strings.isEven(3) must not be successful
    }

    "properly parse letters sum" in {
      Strings.parseLettersSum("a") must beRightDisjunction(97)
      Strings.parseLettersSum("abcd") must beRightDisjunction(394)
      Strings.parseLettersSum("1") must beLeftDisjunction(Strings.InvalidLettersList("1"))
      Strings.parseLettersSum("|\\|07L3773R5") must beLeftDisjunction(Strings.InvalidLettersList("|\\|07L3773R5"))
    }

    "properly return NumberFormatException error" in {
      Strings.parseVal(parseInt)("Not-A-Number") must beFailing
    }

    "properly parseVal integer property" in check(parseValInts)
    "properly parseVal double property" in check(parseValDoubles)

  }

}

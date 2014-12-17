package com.cevaris.validation

import org.specs2.scalaz.ValidationMatchers._
import org.scalacheck._
import org.scalacheck.Prop.forAll

import com.cevaris.SpecTest


class StringsSpec extends SpecTest {

  val parseValRes = forAll { (a: Int) =>
    Strings.parseVal(a.toString) must beSome[Int](a)
  }

  "Strings object" should {
    "properly detect if isEven" in {
      Strings.isEven(2) must beSuccessful
      Strings.isEven(3) must not be successful
    }

    "properly parseVal" in check(parseValRes)

  }

}

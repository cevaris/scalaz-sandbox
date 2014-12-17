package com.cevaris.validation

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

import org.specs2.scalaz.ValidationMatchers._
import org.specs2.mutable.Specification

object StringsSpec extends Specification {

  "Strings object" should {
    "properly isEven" in {

      Strings.isEven(2) must beSuccessful
      Strings.isEven(3) must not be successful
      
    }
  }

}

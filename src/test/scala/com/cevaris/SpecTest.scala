package com.cevaris

import java.util.Random
import org.specs2.ScalaCheck
import org.specs2.execute.{ AsResult, Failure, Result }
import org.specs2.main.CommandLineArguments
import org.specs2.matcher.Parameters
import org.specs2.mutable.Specification
import org.specs2.scalaz.ValidationMatchers._
import org.specs2.specification.{ Example, ExampleFactory }
import scalaz.syntax.monoid._
import scalaz.syntax.std.string._
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

trait SpecTest extends Specification with ScalaCheck with CommandLineArguments {}

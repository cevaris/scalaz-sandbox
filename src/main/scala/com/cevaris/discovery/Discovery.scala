package com.cevaris.discovery


sealed trait DeployEnvironment
case object Production extends DeployEnvironment
case object Staging extends DeployEnvironment
case object Development  extends DeployEnvironment

object Address{
}
case class Address(ipAddress: String, fqdn: String, port: Int)

object Role{
}
case class Role(name: String)

object Node {
}
case class Node(address: Address, role: Role)

object Catalog {
  def apply(fqdn: String): Catalog = {
    val name = "demo"
    val deployEnv = Production

    // Fetch these
    val rs = Set(
      Node(Address("72.111.222.333", "ws00.demo.test", 80), Role("webserver")),
      Node(Address("72.111.222.334", "ws01.demo.test", 80), Role("webserver")),
      Node(Address("72.111.223.333", "mysql00.demo.test", 3306), Role("mysql")),
      Node(Address("72.111.223.334", "mysql01.demo.test", 3306), Role("mysql")),
      Node(Address("72.111.224.333", "mem00.demo.test", 3306), Role("memcached")),
      Node(Address("72.111.224.334", "mem01.demo.test", 3306), Role("memcached"))
    )

    Catalog(name, deployEnv, rs)
  }
}
case class Catalog(name: String, deployEnv: DeployEnvironment, rs: Set[Node])


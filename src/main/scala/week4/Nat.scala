package week4

import java.util.NoSuchElementException

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  // moved here since it was duplicated in both zero and succ
  def successor: Nat = new Succ(this)
  def +(that: Nat): Nat
  def -(that: Nat): Nat
}

object Zero extends Nat {
  override def isZero: Boolean = true

  override def predecessor: Nat = throw new Error("0.predecessor")

  // Duplicate moved to the parent class
  // override def successor: Nat = new Succ(this)

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat = if (that.isZero) this else throw new Error("Negative number")
}


class Succ(n: Nat) extends Nat {

  override def isZero: Boolean = false

  override def predecessor: Nat = n

  // Duplicate moved to the parent class
  // override def successor: Nat = new Succ(this)

  override def +(that: Nat): Nat = new Succ(n + that)

  override def -(that: Nat): Nat = if (that.isZero) this else n - that.predecessor
}

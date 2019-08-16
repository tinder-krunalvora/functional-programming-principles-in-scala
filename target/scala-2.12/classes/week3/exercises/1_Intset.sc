abstract class Intset {
  def incl(x: Int): Intset
  def contains(x: Int): Boolean
  def union(other: Intset): Intset

  override def toString = "."
}

class NonEmpty(elem: Int, left: Intset, right: Intset) extends Intset {
  def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }
  def incl(x: Int): Intset = {
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  def union(other: Intset): Intset = {
    //TODO study clearly
    ((left union right) union other) incl elem
  }

  override def toString: String = "{" + left + elem + right + "}"
}

object Empty extends Intset {
  def contains(x: Int): Boolean = false
  def incl(x: Int): Intset =  new NonEmpty(x, Empty, Empty)
  def union(other: Intset): Intset = other
}

val t1 = new NonEmpty(3, Empty, Empty)
val t2 = t1 incl 4

println(t2.toString)



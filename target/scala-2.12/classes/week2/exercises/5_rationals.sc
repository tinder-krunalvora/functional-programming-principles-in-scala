package week2

class Rational(x: Int, y: Int) {
  // require is a pre defined function
  // Used to enforce a pre condition
  require(y != 0, "denominator must be non zero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  // private val g = gcd(x, y)

  val numer = x
  val denom = y
  // val numer = x / g
  // val denom = y / g

  def + (that: Rational) =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  override def toString = {
    val g = gcd(numer, denom)
    numer / g + " / " + denom / g
  }

  def unary_- = new Rational(-numer, denom)

  def subtract(that: Rational) = this + -that

  def <(that: Rational) = numer * that.denom < denom * that.numer

  def max(that: Rational) = if (this < that) that else this

}

// val x = new Rational(1, 3)
// val y = new Rational(1, 4)
// val z = new Rational(3, 2)

// println(x.toString)
// println(x.add(y).toString)
// x.subtract(y).toString


// new Rational(2)

// infix operator
// x + y






def abs(num: Double): Double = if (num < 0) -num else num


// Newtons method for computing square root
def sqrRoot(num: Double): Double = {


  def isGoodEnough(guess: Double): Boolean = {
    // abs(guess * guess - num) < 0.001

    // improvement for very small and very large values
    abs(guess * guess - num) / num < 0.001
  }

  def improve(guess: Double): Double = {
    // Mean of guess and num/guess
    (guess + num / guess) / 2
  }

  def sqrtIter(guess: Double): Double = {
    if(isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))
  }

  sqrtIter(1.0)
}


sqrRoot(2)
sqrRoot(9)
sqrRoot(1e-6)
sqrRoot(1e60)




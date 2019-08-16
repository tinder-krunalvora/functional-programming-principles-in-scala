// Find fixed point of a function

/*
  A number x is called a fixed point of a function f if f(x) = x
  One way to find it is by doing f(f(f(x)))... until x and f(x) are almost equal.
  */

val tolerance = 0.0001

import Math.abs

def isCloseEnough(x: Double, y: Double): Boolean = {
  (abs((x - y) / x) / x) < tolerance
}

def fixedPoint(f: Double => Double)(firstGuess: Double) = {

  def iterate(guess: Double): Double = {
    // println(s"guess: $guess")
    val nextGuess = f(guess)
    // println(s"next guess: $nextGuess")
    if (isCloseEnough(guess, nextGuess)) nextGuess
    else iterate(nextGuess)
  }

  iterate(firstGuess)
}

// x = 1 + x / 2  :::: the fixed point for this function should be 2
fixedPoint(x => 1 + x / 2)(1)



/*
  sqrt(x) => y such that y * y = x
  which means
  sqrt(x) => y such that y = x / y

  f(y) = x / y
  f(1) = x / 1
  f(sqrt(x)) = x / sqrt(x) = sqrt(x)

  So by definition of a fixed point,
  sqrt(x) is a fixed point of the function (y => x / y)
*/

// def sqrt(x: Double): Double = fixedPoint(y =>  x / y)(1.0)
// sqrt(2)
/*
   In this example above,
   x = 2
   y = 1 // first guess

   f(1) = 2/1 = 2  // next guess
   f(2) = 2/2 = 1  // latest guess

   The above function does not converge since the output oscillates between 1 and 2.

   The solution is change the function:

   Instead of f(y) = x / y

   Average the oscillating values y and x/y so that the guesses start converging

   This process is called averageDamping

   f(y) = (y + x/y) / 2

 */

def sqrt(x: Double): Double = fixedPoint(y => (y + x / y) / 2)(1.0)
sqrt(2)


def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

def cleanerSqrt(x: Double) =
  fixedPoint(averageDamp(y => x / y))(1)


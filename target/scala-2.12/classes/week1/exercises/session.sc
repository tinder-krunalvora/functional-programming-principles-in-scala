
// Tail recursive function: function calls itself as its last action
// Can reuse its stack frame
def gcd(a: Int, b: Int): Int =
  if (b == 0) a else gcd(b, a % b)

gcd(25, 30)
gcd(5, 0)
gcd(0, 5)


// Not a tail recursive function
def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1)

factorial(5)


// Tail recursive factorial
def tailRecFactorial(num: Int): Int = {
  def factorial(acc: Int, num: Int): Int = {
    if (num == 0) acc
    else factorial(acc * num, num - 1)
  }

  factorial(1, num)
}

tailRecFactorial(5)
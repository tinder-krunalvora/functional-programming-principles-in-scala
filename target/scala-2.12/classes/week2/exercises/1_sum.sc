// Sum of ints between a and b

def sumInts(a: Int, b: Int): Int = {
  if (a > b) 0
  else a + sumInts(a+1, b)
}

// Sum of cubes of all integers between a and b

def cube(x: Int) = x * x * x

def sumCubes(a: Int, b: Int): Int = {
  if (a > b) 0
  else cube(a) + sumCubes(a+1, b)
}

// Sum of factorials of all integers between a and b

def factorial(x: Int): Int = {
  if (x == 0) 1
  else x + factorial(x-1)
}

def sumFactorials(a: Int, b: Int): Int = {
  if (a > b) 0
  else factorial(a) + sumFactorials(a+1, b)
}

// ***************************************
// Summing with  higher order functions
// ***************************************


def sum(f: Int => Int, a: Int, b: Int): Int = {
  if (a > b) 0
  else f(a) + sum(f, a+1, b)
}


def numItself(x: Int): Int = x


def betterSumInts(a: Int, b: Int): Int = sum(numItself, a, b)
def betterSumCubes(a: Int, b: Int): Int = sum(cube, a, b)
def betterSumFactorials(a: Int, b: Int): Int = sum(factorial, a, b)

betterSumCubes(2,4)

// Using anonymous functions
def anonSumInts(a: Int, b: Int): Int = sum(x => x, a, b)
def anonSumCubes(a: Int, b: Int): Int = sum(x => x*x*x, a, b)


anonSumCubes(2,4)

// Tail recursive version of sum function
def tailrecSum(f: Int => Int, a: Int, b: Int): Int = {

  def loop(a: Int, acc: Int): Int = {
    if(a > b) acc
    else loop(a+1, f(a) + acc)
  }

  loop(a, 0)
}



// Rewrite sum function to return a function

def sumReturningFunction(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int = {
    if(a > b) 0
    else f(a) + sumF(a+1, b)
  }
  sumF
}

def evenBetterSumInts = sumReturningFunction(x => x)
def evenBetterSumCubes = sumReturningFunction(x => x*x*x)
def evenBetterSumFactorials = sumReturningFunction(factorial)


evenBetterSumCubes(2,4)



// Or even better

sumReturningFunction(cube)(2,4)

// or

sumReturningFunction(x => x*x*x)(2,4)


// To make it more clear, sum function can itself be defined with two sets of parameters

def bestSum(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + bestSum(f)(a+1, b)


bestSum(x => x*x*x)(2, 4)
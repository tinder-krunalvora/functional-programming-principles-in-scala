def product(f: Int => Int)(a: Int, b: Int): Int = {
  if (a > b) 1
  else f(a) * product(f)(a + 1, b)
}

product(x => x * x)(3, 4)



// factorial in terms of product

def factorial(num: Int): Int = {
  if(num == 0) 1
  else product(x => x)(1, num)
}

factorial(5)
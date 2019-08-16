def sum_or_product(base: Int, operate: (Int, Int) => Int)(f: Int => Int)(a: Int, b: Int): Int = {
  if (a > b) base
  else operate(f(a), sum_or_product(base, operate)(f)(a + 1, b))
}

sum_or_product(1, (x,y) => x * y)(x => x*x)(3,4)


// so now
def product(f: Int => Int)(a: Int, b: Int): Int =
  sum_or_product(1, (x,y) => x * y)(f)(a,b)


def sum(f: Int => Int)(a: Int, b: Int): Int =
  sum_or_product(0, (x,y) => x + y)(f)(a,b)
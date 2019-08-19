import week3.exercises.Cons
import week3.exercises.Nil


// Write a function nth which takes an integer n and a list xs and returns the nth element of the list
// elements numbering starts from 0. If n is less than 0 or more than length of list - 1, then throw
// IndexOutofBound

def nth[T](n: Int, xs: List[T]): T = {
  if (xs.isEmpty) throw new IndexOutOfBoundsException
  if (n == 0) xs.head
  else nth(n - 1, xs.tail)
}

val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))

// nth(2, list)
// nth(5, list)
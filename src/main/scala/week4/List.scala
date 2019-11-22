package week4
import week3.{Cons, List, Nil}

/*
  Define an object List{...} with 3 functions in it so that users can create lists of length 0-2 using syntax

  List() //the empty list

  List(1) //the list with single element 1.

  List(2, 3) // the list with elements 2 and 3
 */

object List {
  def apply[T](): List[T] = new Nil
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
  def apply[T](x: T): List[T] = new Cons(x, new Nil)
}

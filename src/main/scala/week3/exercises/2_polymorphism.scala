package week3.exercises

import java.util.NoSuchElementException

// We are going to use the data structure - Cons List which is an immutable linked list.

// It consists of two building blocks:
// Nil - the empty list
// Cons - a cell containing an element and the remainder of the list


/*
  trait IntList

  class Cons(val head: Int, val tail: IntList) extends IntList

  class Nil extends IntList
*/


trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty: Boolean = false
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true

  def head: Nothing = throw new NoSuchElementException("Nil.head")

  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}


// Type parameter on a function
// def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])



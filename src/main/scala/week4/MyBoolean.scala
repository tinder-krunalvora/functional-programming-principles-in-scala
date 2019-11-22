package week4

// Write an idealized Boolean class without using the primitive boolean types

abstract class MyBoolean {

  // Unimplemented ifThenElse
  // condition.ifThenElse(then, else)
  def ifThenElse[T](t: => T, e: => T): T

  // thisTrue thatTrue True
  // thisTrue thatFalse False
  // thisFalse thatTrue False
  // thisFalse thatFalse False
  def &&(that: => MyBoolean): MyBoolean = ifThenElse(that, False)

  def ||(that: => MyBoolean): MyBoolean = ifThenElse(True, that)

  def unary_! : MyBoolean = ifThenElse(True, False)

  def ==(that: => MyBoolean): MyBoolean = ifThenElse(that, !that)

  def !=(that: => MyBoolean): MyBoolean = ifThenElse(!that, that)

  // < method for MyBoolean. Assumption: False < True
  /* thisTrue thatFalse False
     thisTrue thatTrue False
     thisFalse thatTrue True
     thisFalse thatFalse False
   */
  def unary_<(that: => MyBoolean): MyBoolean = ifThenElse(False, that)
}


object True extends MyBoolean {
  override def ifThenElse[T](t: => T, e: => T): T = t
}

object False extends MyBoolean {
  override def ifThenElse[T](t: => T, e: => T): T = e
}

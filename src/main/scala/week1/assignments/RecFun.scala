package week1.assignments

object RecFun extends App {

  /**
   * Exercise 1
    * Write a function that computes the elements of Pascal’s triangle by means of a recursive process.
    *
    * Do this exercise by implementing the pascal function in Main.scala, which takes a column c and a row r,
    * counting from 0 and returns the number at that spot in the triangle.
    * For example, pascal(0,2)=1,pascal(1,2)=2 and pascal(1,3)=3.
   */
    def pascal(c: Int, r: Int): Int = {
      if (c > r) -1
      else if ((c == 0) || (r == c)) 1
      else pascal(c,r-1) + pascal(c-1,r-1)
    }
  
  /**
   * Exercise 2
    * Write a recursive function which verifies the balancing of parentheses in a string,
    * which we represent as a List[Char] not a String.
   */
    def balance(chars: List[Char]): Boolean = {

      def isBalanced(chars: List[Char], stack: List[Char]): Boolean = {
        // println(s"Chars: $chars")
        // println(s"stack: $stack")
        if (chars.isEmpty) stack.isEmpty
        else if (chars.head == '(') {
          isBalanced(chars.tail, stack :+ '(')    // Received a (. Adding it to the stack and verifying the rest of the chars
        }
        else if (chars.head == ')') {
          (!stack.isEmpty) && (stack.head == '(') && isBalanced(chars.tail, stack.tail)
        }
        else isBalanced(chars.tail, stack)
      }

      isBalanced(chars, List[Char]())
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if ((money < 0) || (coins.isEmpty)) 0
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }

  // println("Pascal's Triangle")
  for (row <- 0 to 10) {
    for (col <- 0 to row)
    // print(pascal(col, row) + " ")
      println()
  }
  // println(balance("(if (zero? x) max (/ 1 x))".toList))
  println(countChange(4,List(1,2)))


}

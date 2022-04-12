package essential_scala

object Day6 extends App {

  // ----- Sequencing Computations --------> Monadas y Functores

  sealed trait IntList {
    def length: Int =
      this match {
        case End => 0
        case Pair(_, tl) => 1 + tl.length
      }
    def double: IntList =
      this match {
        case End => End
        case Pair(hd, tl) => Pair(hd * 2, tl.double)
      }
    def product: Int =
      this match {
        case End => 1
        case Pair(hd, tl) => hd * tl.product
      }
    def sum: Int =
      this match {
        case End => 0
        case Pair(hd, tl) => hd + tl.sum
      }
  }

  // --- 5.1 Generics ---

  final case class Box[A](value: A) // A - type parameter
  Box(2).value // 2
  Box[String]("2").value // "2"

  def generic[A](in: A): A = in

    // Generic Algebraic Data Types

//    sealed trait Calculation
//    final case class Success(result: Double) extends Calculation
//    final case class Failure(reason: String) extends Calculation

      // Invariant Generic Sum Type Pattern

    sealed trait Result[A]
    final case class Success[A](result: A) extends Result[A]
    final case class Failure[A](reason: String) extends Result[A]

  // --- 5.2 Functions ---

  sealed trait IntListAbstraction extends IntList {
//    def abstraction(end: Int, f: ???): Int =
//      this match {
//        case End => end
//        case Pair(hd, tl) => f(hd, tl.abstraction(end, f))
//      }
  }

  case object End extends IntListAbstraction
  final case class Pair(head: Int, tail: IntList) extends IntListAbstraction

      // 5.2.1 Function Types // func: (String, String) => Int
        def executeFunction[A, C](num1: A, num2: A)(func: (A, A) => C): C =
          func(num1, num2)

        println(executeFunction("2", "4")(_.toInt + _.toInt))
        println(executeFunction(4, 5)((num1, num2) => (num1 + num2).toString))
}

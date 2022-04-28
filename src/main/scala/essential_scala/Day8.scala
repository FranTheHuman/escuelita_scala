package essential_scala

object Day8 extends App {

  // ---- 5.4 Modelling Data with Generic Types ----

  // Generic Product Types

  case class IntAndString(int: Int = 0, string: String = "")

  case class Pairr[A, B](one: A, two: B)

  def intAndString: Pairr[String, Int] = Pairr("hi", 2)

  case class BooleanAndDouble(booleanValue: Boolean, doubleValue: Double)

  def booleanAndDouble /*: ???*/ = ???

      // 5.4.2 Tuples

  val tuple: (String, Int, String, Boolean, Boolean) = ("Marce", 100, "Scala", true, false)

  def tuplized[A, B](in: (A, B)) = in._1
  println(tuplized(("a", 1)))

  (1, "a") match {
    case (a, b) => a + b
  }

  // 5.4.3 Generic Sum Types

  sealed trait Sum[A, B]
  case class Left[A, B](value: A) extends Sum[A, B]
  case class Right[A, B](value: B) extends Sum[A, B]

  def intOrString(input: Boolean): Any =
    if(input) 123 else "abc"

  def intOrString_2(input: Boolean): Sum[Int, String] =
    if(input) {
      Left[Int, String](123)
    } else {
      Right[Int, String]("abc")
    }

      // Generic Optional Values

      // -> Opcionales bro

  // 5.5 Sequencing Computation

    // "" map and flatMap. ""

//     sealed trait LinkedList[A] {
//       //       def fold[B](end: B)(f: (A, B) => B): B =
//       //         this match {
//       //           case End() => end
//       //           case Pair(hd, tl) => f(hd, tl.fold(end)(f))
//       //         }
//       def map[B](fn: A => B): LinkedList[B] =
//         this match {
//           case Pair(hd, tl) => Pair(fn(hd), tl.map(fn))
//           case End() => End[B]()
//         }
//     }
//     final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]
//     final case class End[A]() extends LinkedList[A]

  private def getCaptcha_ApiKey(fromHost: Option[String]): String = {
    fromHost match {
      case Some(fromHost2) if fromHost2.contains("decidir") => "" //config.secret.split(",")(0)
      case Some(fromHost2) if fromHost2.contains("payway") => "" //config.secret.split(",")(1)
      case None =>
       //  logger.error("URL is not valid")
        ""
    }
  }

}

package essential_scala

object Day7 extends App {

  // 5.3 Generic Folds for Generic Data

  // 3 patrones Fold que trae scala en las mayoria de las cajitas (List, Future, Option, Either, Etc)
  //   -> fold : Aplicar expresiones alebraicas a la caja (List, Future, Etc) -> No tail Recursive
  //   -> foldRight : Transformacion de cajas (List, Future, Etc) y empieza a recorrer las Listas desde la derecha -> Si tail Recursive
  //   -> foldLeft  : Transformacion de cajas (List, Future, Etc) y empieza a recorrer las Listas desde la izquierda -> No es tail Recursive

  // FOLD

  /*
    Fold is just an adaptation of structural recursion where we allow the user to pass in the functions we apply at each case.
    As structural recursion is the generic pattern for writing any function that transforms an algebraic datatype,
    fold is the concrete realisation of this generic pattern. That is, fold is the generic transformation or iteration method.
    Any function you care to write on an algebraic datatype can be written in terms of fold.
  */

  sealed trait LinkedList[A] {
    def fold[B](end: B)(f: (A, B) => B): B =
      this match {
        case End() => end
        case Pair(hd, tl) => f(hd, tl.fold(end)(f))
      }
  }
  final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]
  final case class End[A]() extends LinkedList[A]

  val l = List(1, 5)
  val l2 = List("1", "5")
  val l3 = Right(1).withLeft[String]

  print(l.fold(0)(_ + _))
  println(l2.fold("")(_ + " " + _))
  println(l3.fold(a => a + " Holis Rouse", a => a + 2))

  // Converting methods to functions

  object Sum {
    def sum(x: Int, y: Int) = x + y
  }
  // Sum.sum
  // (Sum.sum _)

  object MathStuff {
    def add1(num: Int) = num + 1
  }
  class Counter(initial: Int) {
    def adjust(f: Int => Int): Int = f(initial)
  }

  Counter(2).adjust(MathStuff.add1)

  def example(x: Int)(y: Int) = x + y

//  def fold[B](end: B)(pair: (A, B) => B): B =
//    this match {
//      case End() => end
//      case Pair(hd, tl) => pair(hd, tl.fold(end, pair))
//    }

//  fold(0) {
//    (total, elt) =>
//      println("Llamo a un microservicio")
//      total + elt
//  }

}

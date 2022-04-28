package essential_scala

object Day9 {

  sealed trait Maybe[A] {
    def flatMap[B](fn: A => Maybe[B]): Maybe[B] = // F[A] / A => F[B] / F[B]
      this match {
        case Full(v) => fn(v)
        case Empty() => Empty[B]()
      }
  }
  final case class Full[A](value: A) extends Maybe[A]
  final case class Empty[A]() extends Maybe[A]

  // 5.5.3 Functors and Monads

    // FUNCTOR - A type like F[A] with a map method is called a functor
    // MONADS - If a functor also has a flatMap method it is called a monad.

  def mightFail1: Maybe[Int] =
    Full(1)

  def mightFail2: Maybe[Int] =
    Full(2)

  def mightFail3: Maybe[Int] =
    Empty() // This one failed

  mightFail1 flatMap { x =>
    mightFail2 flatMap { y =>
      mightFail3 flatMap { z =>
        Full(x + y + z)
      }
    }
  }

  /*

    We use map when we want to transform the value within the context to a new value, while keeping the context the same.
    We use flatMap when we want to transform the value and provide a new context.

  */

}

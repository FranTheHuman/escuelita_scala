package essential_scala

import scala.annotation.tailrec

object Day5 extends App {

  // ------- Choosing Which Pattern to Use --------

  // EFICIENCIA ????

  // 1. polymorphism;
    // -> Si depende de datos de cada clase especifica es el camino
  // 2. pattern matching in the base trait; and
    // -> Si depende de objetos especificos externos a la clase en cuestion es el camino
  // 3. pattern matching in an external object
    // -> Si depende de objetos especificos externos a la clase en cuestion es el camino

  // Object-Oriented vs Functional Extensibility

  trait Food
  case object Antelope extends Food
  case object TigerFood extends Food
  case object Licorice extends Food
  case class CatFood(food: Food) extends Food

  sealed trait Feline {
    def dinner: Food =
      this match {
        case Lion() => Antelope
        case Tiger() => TigerFood
        case Panther() => Licorice
        case Cat(favouriteFood) => CatFood(favouriteFood)
        case MountainLion() => Antelope
      }
    def hunt: Food =
      this match {
        case Lion() => ???
        case Tiger() => ???
        case Panther() => ???
        case Cat(favouriteFood) => ???
        case MountainLion() => ???
      }
  }

  case class Lion() extends Feline
  case class Tiger() extends Feline
  case class Panther() extends Feline
  case class Cat(favouriteFood: Food) extends Feline
  case class MountainLion() extends Feline

  // Recursive Data

  sealed trait IntList
  case object End extends IntList
  final case class Pair(head: Int, tail: IntList) extends IntList

  Pair(1, Pair(2, Pair(3, Pair(4, Pair(5, End)))))

  val end = End
  val c = Pair(3, end)
  val b = Pair(2, c)
  val a = Pair(1, b)

  val example = Pair(1, Pair(2, Pair(3, End)))

  assert(sum(example) == 6)
  assert(sum(example.tail) == 5)
  assert(sum(End) == 0)

  def sum(list: IntList): Int =
    list match {
      case End => 0
      case Pair(head, tail) => head + sum(tail)
    }

  // Caso base = identity = elemento que no cambia el resultado

  def sum_2(list: List[Int]): Int =
    list match {
      case Nil => 0
      case ::(head, next) => head + sum_2(next)
    }

  // println(sum_2((1 to 10000).toList)) // ROMPE

  @tailrec
  def sumTail(list: List[Int], total: Int = 0): Int =
    list match {
      case Nil => total
      case ::(head, next) => sumTail(next, total + head)
    }

  println(sumTail((1 to 10000).toList))
}

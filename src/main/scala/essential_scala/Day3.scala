package essential_scala

import java.util.Date

object Day3 extends App {

  // ------- Features of a case class companion object -------

    // Preferimos apply antes que constructor porque omitimos la palabra reservada new

  // ------- Case objects -------

      // Si tenemos un case class sin argumentos lo cambiamos por case object
      // Tiene mas sentido el metodo toString en los case object

      case object Marcelo
      println(Marcelo.toString)

  // ------- 3.5 Pattern Matching -------

      // Pattern matching is like an extended if expression that allows us to evaluate an expression depending on the “shape” of the data.

  case class Person(firstname: String, lastName: String)

  object Stormtrooper {
    def inspect(person: Person): String =
      person match {
        case Person("Luke", "Skywalker") => "Stop, rebel scum!"
        case Person("Han", "Solo") => "Stop, rebel scum!"
        case Person(first, last) => s"Move along, $first"
      }

  }

  val asd: Either[Int, String] = Option("Hola Rosa") match {
    case Some(str: String) => Left(1)
    case None => Right("asd")
  }

  val rosa: Either[String, String] = Right("Hola Rosa")
  val asd_2 = rosa match {
    case Right("Hola Rosa") => "Chau Rosa"
    case Right("Comprate un tender rosa") => ":c"
    case Right("Deja de fumar") => ":c"
    case Right(_) => "No te vas a salvar rosa"
    case Left(_) => ":'c"
  }

  // ------- 4 Modelling Data with Traits -------

    // Traits are templates for creating classes

  sealed trait Visitor {
    def id: String      // Unique id assigned to each user
    def createdAt: Date // Date this user first visited the site

    // How long has this visitor been around?
    def age: Long = new Date().getTime - createdAt.getTime
    def isRosaFriend: Boolean = false
  }

  final case class Anonymous(
    id: String,
    createdAt: Date = new Date()
  ) extends Visitor

  final case class User(
    id: String,
    email: String,
    createdAt: Date = new Date()
  ) extends Visitor {
    override def isRosaFriend: Boolean = true
  }

  // Clases anonimas
  val c: Visitor = new Visitor {
    override def id: String = "???"
    override def createdAt: Date = new Date()
  }

  println(c.id)

  // ------- Sealed Traits -------

  def patermatcheando(v: Visitor): Any = v match {
    case Anonymous(id, createdAt) => println("Chauchis")
    case User(id, email, createdAt) => println("")
    case _ => println("holis")
  }

  patermatcheando(Anonymous("as", new Date()))

}

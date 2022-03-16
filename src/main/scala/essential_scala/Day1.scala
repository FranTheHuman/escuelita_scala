package essential_scala

object Day1 extends App {

  // 2 - TYPES / EXPRESSIONS / VALUES

  // a. Types
         // Todo es un objeto :3
         def a: Function[Int, Int] = ??? // objeto que actua como funcion

          case class Random()

          // ANY ---- Extiende de todos los tipos
          def receive(msg: Any): Unit = msg match {
            case Int => ()
            case Random => ()
            case Char => ()
            case Boolean => ()
            case Int => ()
            // case String => () -> String no funciona - Averiguar porque
            case _ => ()
          }

          // Nothing ----- Todos extienden de el
          def as: Nothing = ???
          def as1: Int = ???
          def as2: Boolean = ???

  // b. Expresiones
        // parte de un programa que evaluan un valor
        // 1 + 1
        // 2 / 5
        // usuario guardate repo
        // validacion1 |+| validacion2

  // v. Values ----
        // espacio en memoria

  // 3 - CLASS / OBJECTS

  // Class Scala = Class Java (pero mas linda/acotada)
    class Person(atributo1: String = "") {

      private val atributo2 = "Cindy despertate"

      def hacerTrabajarAMarce(): String = {
        atributo1 + "Pero ponete a laburar - " + atributo2
      }

    }
    new Person("Marce es mi idolo")

}

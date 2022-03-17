package essential_scala

object Day2 extends App {

  // ------- 3.2.1 - The apply method -------

    // Podemos utilizar los objetos como funciones gracias al metodo apply

  class Mauro() {
    def apply(atr1: String, atr2: Int): Mauro = ???
    def greater(atr1: String, atr2: Int): Mauro = ???
  }

  val mauro = new Mauro()

  mauro("", 2) == mauro.apply("", 2)
  mauro.greater("", 2)

  // ------- 3.3 Companion Objects -------

  // Datos
  class Timestamp(val seconds: Long)

  // Comportamiento
  object Timestamp {
    def apply(hours: Int, minutes: Int, seconds: Int): Timestamp =
      new Timestamp(hours * 60 * 60 + minutes * 60 + seconds)
    def saludaAivo(mensaje: String): String = "Hola ivo " + mensaje
  }

  Timestamp(1, 1, 1).seconds
  Timestamp.saludaAivo("Ivo no te vayas")

  // ------- 3.4 Case Classes -------

    // Cases simples con cosas definidas por defecto

    case class F(asd: String) // keyword case

    // Viene con el companion object ya definido

    // Features of a case class

      // 1.
          // no hay necesidad de especificar val
          case class Random1(atr1: String) // No hay mutabilidad de atributo

      // 2.
          // A default toString method
          // (no more @ signs and cryptic hex numbers): 
          // Person(Dave,Gurnell)

      // 3.
          //  Sensible equals, and hashCode methods that operate on the field values in the object.

      // 4.
          // A copy method that creates a new object with the same field values as the current one:

          case class State(asd: Int)
          object State {
            def +(s: State): State = s.copy(asd = s.asd + 1)
            def -(s: State): State = s.copy(asd = s.asd - 1)
          }

      // 5.
        // Case classes implement two traits: java.io.Serializable and scala.Product
        // provides methods for inspecting the number of fields and the name of the case class.

}

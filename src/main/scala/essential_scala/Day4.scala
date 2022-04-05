package essential_scala

object Day4 extends App {

  // ------- Algebraic data types -------

  // Product type / AND = eq composicion ???
    // - pattern is to model data that contains other data.

    // Como pensarlo --- “Programmer has a LenguajeFav and AñosExperiencia”

  case class LenguajeFav()
  case class AñosExperiencia()
  case class Programmer(lenguaje: LenguajeFav, años: AñosExperiencia)

  // Sum type / OR = eq herencia ???
    // - pattern is to model data that can be different cases

    // Como pensarlo --- “Programador is a Rouse or Mau or Juan”

  sealed trait Programador
  final case class Rouse() extends Programador
  final case class Mau() extends Programador
  final case class Juan() extends Programador

  // Combinaciones entr product y sum

    // como pensarlo --- “Will is-a TrabajadorTecnico and TrabajadorFuncional”

    trait TrabajadorTecnico
    trait TrabajadorFuncional
    trait Will extends TrabajadorTecnico with TrabajadorFuncional

    // Como pensarlo --- “Felino has-a Rojo or Verde”

    trait Felino {
      def color: Color
    }
    sealed trait Color
    final case class Rojo() extends Color
    final case class Verde() extends Color

  // --- structural recursion (Polymorphism / Pattern Matching)  ---

  case class Comida()
  case class Sonido(msg: String)

  // The Product Type Polymorphism Pattern
  case class Leon(color: Color, comida: Comida) {
    def rugir: Sonido = ???
  }

  // The Sum Type Polymorphism Pattern
  sealed trait Sonido_2 {
    def makeSound: Sonido
    def hunt: Unit
  }
  final case class Tigre(colorr: Color, comida: Comida) extends Sonido_2 with Felino {
    def makeSound: Sonido = ???
    override def color: Color = colorr
    override def hunt: Unit = ???
  }
  final case class Gato(colorr: Color, comida: Comida) extends Sonido_2 with Felino {
    def makeSound: Sonido =  ???
    override def color: Color = colorr
    override def hunt: Unit = ???
  }
  final case class Pantera(colorr: Color, comida: Comida) extends Sonido_2 with Felino {
    def makeSound: Sonido =  ???
    override def color: Color = colorr
    override def hunt: Unit = ???
  }

  //  The Product Type Pattern Matching Pattern

  trait Felino2 {
    def makeSound_2: Sonido =
      this match {
        case t: Tigre_2 => ???
      }
  }
  case class Tigre_2(colorr: Color, comida: Comida) extends Felino2

  def takeComida(felino: Felino2): Comida =
    felino match {
      case Tigre_2(color, comida) => comida // utilizando color y comida construimos el resultado
    }

  // The Sum Type Pattern Matching Pattern
  def makeSound_2(felino: Felino): Sonido =
    felino match {
      case t: Tigre => ???
      case g: Gato => ???
    }

}

/**
 * Las clases pueden ser declarados en cualquier scope (alcance), ya sea globalmente,
 * dentro de funciones, dentro de otras clases, etc.
 */

// Esta es una clase global

class ClaseGlobal {
    val atributo = 10

    fun metodo() {

    }
}

fun main() {
    claseTradicional()
    claseConConstructor()
    claseConPropiedades()
    clasePOJO()
}

fun claseTradicional() {

    // definicion de una clase con atributos y metodos

    class Abecedario {
        val a = 'a'
        val b = 'b'
        val c = 'c'

        fun imprimirA() {
            println(a)
        }

        fun imprimirB() {
            println(b)
        }

        fun imprimirC() {
            println(c)
        }
    }

    // instanciando una clase (creando un objeto)

    val abc = Abecedario()

    abc.imprimirA()
    abc.imprimirB()
    abc.imprimirC()
}

fun claseConConstructor() {

    // el constructor se define junto con el nombre de la clase

    class Saludador(nombre: String) {

        val nombre: String = nombre

        fun saludar() {
            println("Hola $nombre")
        }
    }

    val saludador = Saludador("Alejandro")
    saludador.saludar()

    // si se requieren hacer mas calculos, se puede utilizar el bloque init para inicializar la clase

    class Rectangulo(base: Float, altura: Float) {

        private var perimetro: Float = 0.0f
        private var area: Float = 0.0f

        init {
            perimetro = (base * 2) + (altura * 2)
            area = (base * altura) / 2
        }

        fun obtenerPerimetro(): Float {
            return perimetro
        }

        fun obtenerArea(): Float {
            return area
        }
    }

    val rect = Rectangulo(10f, 6f)
    println(rect.obtenerPerimetro())
    println(rect.obtenerArea())

    /**
     * Una clase puede tener mas de un constructor. Siempre debe de haber un constructor primario, y si
     * se tienen mas constructores, estos deben de llamar al constructor primario
     */

    class Persona(val nombre: String) {

        val amigos = ArrayList<Persona>()

        constructor(nombre: String, amigo: Persona) : this(nombre) {
            amigos.add(amigo)
        }

        constructor(nombre: String, amigos: List<Persona>) : this(nombre) {
            this.amigos.addAll(amigos)
        }
    }

    val pablo = Persona("Pablo")
    val alejandro = Persona("Alejandro", pablo)
    val johnny = Persona("Johnny", listOf(pablo, alejandro))
}

fun claseConPropiedades() {

    // se pueden declarar los atributos de una clase directamente en el constructor

    class Usuario(private val nombreUsuario: String, private val correo: String, private val contrasena: String) {

        fun mostrarInformacion() {
            println("Nombre de usuario: $nombreUsuario")
            println("Correo electronico: $correo")
            println("Contrasena: $contrasena")
        }
    }

    val usuario = Usuario("alex", "ale@live.com", "123")
    usuario.mostrarInformacion()

}

fun clasePOJO() {

    /**
     * Las clases POJO (tambien conocidas como JavaBeans) se utilizan para representar entidades
     * Al declarar una clase como data class, automaticamente se generan los getters y setters
     */

    data class Persona(val nombre: String, val apellidoPaterno: String, val apellidoMaterno: String)

    // Es obligatorio pasar los atributos al constructor

    val persona = Persona("Alejandro", "Castillo", "Ramirez")
    println(persona.nombre)
    println(persona.apellidoPaterno)
    println(persona.apellidoMaterno)

    /**
     * Se pueden establecer valores por defecto a los atributos de un data class. De esta manera
     * no es obligatorio pasar los atributos al constructor
     */

    data class Alumno(
        val matricula: String = "",
        val nombre: String = "",
        val apellidoPaterno: String = "",
        val apellidoMaterno: String = "",
        val semestre: Int = 1
    )

    val alumno = Alumno()
    println(alumno.matricula)
    println(alumno.nombre)
    println(alumno.apellidoPaterno)
    println(alumno.apellidoMaterno)
    println(alumno.semestre)
}
























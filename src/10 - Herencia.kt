fun main() {
    herencia()
}

fun herencia() {

    /**
     * Para heredar de una clase se tiene que declarar como open.
     * Igualmente, si en algun momento se piensa sobreescribir un metodo heredado, se tiene que marcar como open
     */

    /**
     * Aqui estamos creando una clase de tipo Persona con las propiedades nombre, apellidoP y apellidoM
     * y con un metodo presentarse
     */
    open class Persona(val nombre: String, val apellidoP: String, val apellidoM: String) {
        open fun presentarse() {
            println("Hola, mi nombre es $nombre $apellidoP $apellidoM")
        }
    }

    /**
     * Aqui estamos creando una clase de tipo Alumno que hereda de Persona, por lo tanto tambien tiene
     * las propiedades nombre, apellidoP y apellidoM, ademas de tener sus propias propiedades matricula
     * y carrera y su propio metodo estudiar
     */
    class Alumno(
        val matricula: String,
        val carrera: String,
        nombre: String,
        apellidoP: String,
        apellidoM: String
    ) : Persona(nombre, apellidoP, apellidoM) {

        fun estudiar() {
            println("Yo $nombre, estoy estudiando...")
        }
    }

    /**
     * Aqui estmamos creando una clase de tipo Profesor que hereda de Persona, por lo tanto tambien tiene
     * las propiedades nombre, apellidoP, apellidoM, ademas de tener sus propias propiedades codigo y academia
     * y su propio metodo encargar tarea
     *
     * En este caso se esta sobreescribiendo el metodo presentarse de la clase Persona
     */
    class Profesor(
        val codigo: String,
        val academia: String,
        nombre: String,
        apellidoP:
        String,
        apellidoM: String
    ) : Persona(nombre, apellidoP, apellidoM) {

        fun encargarTarea() {
            println("Yo $nombre, estoy encargando tarea...")
        }

        override fun presentarse() {
            println("Hola, soy el profesor $nombre $apellidoP $apellidoM de la academia de $academia")
        }
    }
}

fun herenciaConstructores() {



}

// variables globales

var entero: Int = 10
var flotante: Float = 1.5f
var doble: Double = 3.1416
var largo: Long = 99999999999999
var bandera: Boolean = true
var caracter: Char = 'a'
var nombre: String = "Alejandro"

// variables globales constantes (no se puede cambiar su valor una vez que es asignado)
val x: Int = 10
val y: Int = x

fun main() {

    /*
    Los tipos de las variables se pueden inferir, por lo tanto no es necesario declarar su tipo,
    aunque es buena practica hacerlo si no se muestra su tipo explicitamente
     */

    // variables locales
    var localX = 10
    var localY = localX

    localY = y // No marca error porque localY esta declarada como 'var'

    // variables locales constantes
    val constX = 10
    val constY = constX

    //constY = 10 // ERROR porque constY esta declarada como 'val'
}

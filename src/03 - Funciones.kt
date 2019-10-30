fun main() {
    saludar()

    saludar("Alejandro")

    println(sumar(1, 2))

    val nombres = "Pablo Alejandro"
    val apellidoPaterno = "Castillo"
    val apellidoMaterno = "Ramirez"
    val nombreCompleto = nombreCompleto(nombres, apellidoPaterno, apellidoMaterno)
    println(nombreCompleto)
}

// Funcion sin tipo de retorno (equivalente a funciones void en Java)

fun saludar() {
    println("Hola")
}

// Funcion sin tipo de retorno con parametro

fun saludar(nombre: String) {
    println("Hola $nombre")
}

// Funcion con tipo de retorno y con parametros

fun sumar(a: Int, b: Int): Int {
    return a + b
}

fun nombreCompleto(nombres: String, apellidoPaterno: String, apellidoMaterno: String): String {
    return "$nombres $apellidoPaterno $apellidoMaterno"
}

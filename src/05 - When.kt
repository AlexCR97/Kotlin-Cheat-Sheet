/*
* La sentencia when es el equivalente de switch en Java (con muchas mas funcionalidades)
* */

fun main() {

    verificarNumero(3)

    esParImpar(2)

    esParImpar(7)

    val lenguaje: String = determinarLenguaje("Hello")
    println(lenguaje)

    otroEjemplo(1)
    otroEjemplo("Hola")
    otroEjemplo(!true && false)
    otroEjemplo(3.1416)

}

// when tradicional

fun verificarNumero(numero: Int) {
    when (numero) {
        1 -> println("Numero 1")
        2 -> println("Numero 2")
        3 -> println("Numero 3")
        4 -> println("Numero 4")
        5 -> println("Numero 5")
        else -> println("Desconocido")
    }
}

// when con multiples casos

fun esParImpar(num: Int) {
    when (num) {
        2, 4, 6, 8, 10 -> println("El numero es par")
        1, 3, 5, 7, 9 -> println("El numero es impar")
    }
}

// when como expresion

fun determinarLenguaje(saludo: String): String {
    return when (saludo) {
        "Hola" -> "Espanol"
        "Hello" -> "Ingles"
        "Bonjour" -> "Frances"
        else -> "Desconocido"
    }
}

// when con multiples tipos

fun otroEjemplo(objeto: Any) {
    when (objeto) {
        1 -> {
            println("Es un numero")
            println("Es un entero")
        }

        "Hola" -> {
            println("Es una cadena")
        }

        is Boolean -> {
            println("Es un Booleano")
        }

        !is String -> {
            println("No es un String")
        }
    }
}

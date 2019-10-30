fun main() {
    checarEdad(16)
    checarEdad(21)

    val a = 10
    val b = 20
    val c = obtenerMayor(a, b)
    println(c)

    println(convertirEnteroString(3))
}

// If tradicional

fun checarEdad(edad: Int) {
    if (edad < 18) {
        println("Eres menor de edad")
    }
    else {
        println("Eres mayor de edad")
    }
}

// If como expresion (equivalente a operador ternario en Java)

fun obtenerMayor(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// If como expresion extendida

fun convertirEnteroString(num: Int): String {
    val str = if (num == 1) {
        "uno"
    } else if (num == 2) {
        "dos"
    } else if (num == 3) {
        "tres"
    } else if (num == 4) {
        "cuatro"
    } else {
        "cinco"
    }

    return str
}

fun main() {

    forTradicional()
    println("===================")

    forInverso()
    println("===================")

    recorrerString("Esta es una cadena de texto")
    println("===================")

    val arr = IntArray(10)
    for (i in 0 until arr.size)
        arr[i] = i + 1
    recorrerArreglo(arr)
    println("===================")

    // Lista
    val frutas = listOf("manzana", "naranja", "sandia", "kiwi")
    recorrerLista(frutas)
    println("===================")
}

// for tradicional

fun forTradicional() {

    // se especifica el comienzo, el final y el incremento
    for (i in 0 until 10 step 1) {
        print("$i ")
    }
    println()

    // no es necesario especificar el incremento si es de 1
    for (i in 0 until 10) {
        print("$i ")
    }
    println()
}

// for inverso

fun forInverso() {

    // se especifica el comienzo y el final
    for (i in 10 downTo 0) {
        print("$i ")
    }
    println()

    // para simular un decremento especificas el rango normalmente, y luego lo inviertes
    for (i in (0 until 10 step 3).reversed()) {
        print("$i ")
    }
    println()
}

// for para recorrer colecciones

fun recorrerString(str: String) {
    for (caracter in str)
        print("$caracter, ")
    println()
}

fun recorrerArreglo(arr: IntArray) {
    for (i in arr)
        print("$i ")
    println()
}

fun recorrerLista(list: List<*>) {
    for (i in list)
        print("$i ")
    println()
}

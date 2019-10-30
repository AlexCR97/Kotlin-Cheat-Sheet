fun main() {
    arreglos()
    listas()
    mapas()
}

fun arreglos() {

    // Arreglos de tipos primitivos (Int, Float, Double, Boolean, Char)

    val enteros = IntArray(5)
    enteros[0] = 0
    enteros[1] = 1
    enteros[2] = 2
    enteros[3] = 3
    enteros[4] = 4

    val flotantes = FloatArray(3)
    flotantes[0] = 1.1f
    flotantes[1] = 2.2f
    flotantes[2] = 3.3f

    // Indexando los elementos de un arreglo

    val variable: Float = flotantes[0] + flotantes[1] + flotantes[2]

    // Recorrer un arreglo con un indice y el tamano del arreglo

    for (i in 0 until enteros.size)
        print("${enteros[i]}")
    println()

    // Recorrer un arreglo con un iterador

    for (i in flotantes)
        print("$i ")
    println()


    // Recorrer un arreglo alreves

    val letras = CharArray(4)
    letras[0] = 'h'
    letras[1] = 'o'
    letras[2] = 'l'
    letras[3] = 'a'

    for (i in letras.size - 1 downTo 0)
        print("${letras[i]} ")
    println()

    // Tambien se pueden recorrer strings, ya que los strings con arreglos de chars

    val palabra = "palindromo"

    for (caracter in palabra)
        print("$caracter ")
    println()
}

fun listas() {

    // Creacion de listas

    val nombres = ArrayList<String>()
    nombres.add("Pablo")
    nombres.add("Alejandro")
    nombres.add("Castillo")
    nombres.add("Ramirez")

    // Indexando listas

    val primerNombre = nombres[0]
    val segundoNombre = nombres.get(1)
    val apellidos = "${nombres[2]} ${nombres.get(3)}"

    val nombreCompleto = "$primerNombre $segundoNombre $apellidos"

    // Llenando una lista con un for

    val numeros = ArrayList<Double>()

    for (num in 1 until 10)
        numeros.add(num.toDouble())

    // Recorriendo listas con un indice y el tamano de la lista

    for (indice in 0 until numeros.size)
        println(numeros[indice])
    println("==========")

    // Recorriendo listas con los indices

    for (posicion in numeros.indices)
        println(numeros[posicion])
    println("==========")

    // Recorriendo listas con un iterador (ESTA ES LA MANERA MAS COMUN DE RECORRER LISTAS)

    for (i in numeros)
        println(i)
    println("==========")

    // Recorriendo listas con indice y valor

    for ((index, value) in numeros.withIndex()) {
        val indice = index
        val valor = value

        println("[$indice] = $valor")
    }
    println("==========")

    // Checar si una lista contiene un elemento

    if ("Pablo" in nombres) {
        println("La lista $nombres contiene el nombre Pablo")
    }

    if ("Andres" !in nombres) {
        println("La lista $nombres no contiene el nombre Andres")
    }
}

fun mapas() {

    // Creacion de mapas

    val calificaciones = HashMap<String, Float>()
    calificaciones["Alejandro"] = 100f
    calificaciones.put("Santana", 90f)

    // Indexando mapas

    val califAlejandro = calificaciones["Alejandro"]
    val califSantana = calificaciones.get("Santana")

    // Recorriendo un mapa con un iterador

    for (i in calificaciones) {
        val nombre = i.key
        val calif = i.value

        println("La calificacion de $nombre es $calif")
    }

    // Recorriendo un mapa con la llave y el valor (ESTA ES LA MANERA MAS COMUN DE RECORRER MAPAS)

    for ((k, v) in calificaciones) {
        val nombre = k
        val calif = v

        println("La calificacion de $nombre es $calif")
    }

}

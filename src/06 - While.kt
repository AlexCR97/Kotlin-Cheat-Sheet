fun main() {

    tablaMultiplicar(1)
    println("===================")

    tablaMultiplicar(2)
    println("===================")

    tablaMultiplicar(3)
    println("===================")

    tablaMultiplicar(4)
    println("===================")

    tablaMultiplicar(5)
    println("===================")

    for (i in 6 until 11) {
        tablaMultiplicar(i)
        println("===================")
    }
}

// while tradicional

fun tablaMultiplicar(x: Int) {
    var i = 1
    while (i <= 10) {
        println("$x * $i = ${x * i}")
        i++
    }
}

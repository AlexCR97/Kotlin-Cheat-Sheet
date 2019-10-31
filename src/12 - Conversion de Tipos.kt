fun main() {
    conversionTiposPrimitivos()
    conversionTiposAbstractos()
}

fun conversionTiposPrimitivos() {

    /**
     * Los tipos de dato primitivo tienen metodos para convertir a cualquier otro tipo de dato primitivo
     */

    val numString: String = "123"
    val numInt: Int = numString.toInt()
    val numFloat: Float = numString.toFloat()
    val numDouble: Double = numString.toDouble()

    val boolString: String = "true"
    val bool: Boolean = boolString.toBoolean()

    val num1: Int = 10
    val num1String: String = numInt.toString()

    val num2: Float = 1.5f
    val num2String: String = num2.toString()
    val num2Double: Double = num2.toDouble()
}

fun conversionTiposAbstractos() {

    /**
     * A veces es necesario convertir de un tipo de dato abstracto a otro, para ello se usa la palabra reservada 'as'
     */

    // Declaramos una clase base Figura

    abstract class Figura(val nombre: String, val color: String)

    // Hacemos tres clases derivadas de Figura

    class Circulo(val radio: Double, nombre: String, color: String) : Figura(nombre, color)

    class Cuadrado(val lado: Double, nombre: String, color: String) : Figura(nombre, color)

    class Triangulo(val base: Double, val altura: Double, nombre: String, color: String) : Figura(nombre, color)

    // Ahora podemos hacer una lista de Figuras

    val figuras = ArrayList<Figura>()
    figuras.add(Circulo(3.5, "Circulo", "Verde"))
    figuras.add(Cuadrado(6.75, "Cuadrado", "Rojo"))
    figuras.add(Triangulo(7.15, 12.78, "Triangulo", "Azul"))

    /**
     * Si queremos acceder a las propiedades especificas de cada subclase, es necesario hacer una conversion
     */

    // Si no convertimos, solo obtenemos las propiedades de la clase padre

    val figura = figuras[0]
    figura.nombre
    figura.color

    // Si convertimos, obtenemos las propiedades especificas, ademas de las propiedades de la clase padre

    val circulo = figuras[0] as Circulo
    circulo.radio
    circulo.nombre
    circulo.color

    val cuadrado = figuras[1] as Cuadrado
    cuadrado.lado
    cuadrado.nombre
    cuadrado.color

    val triangulo = figuras[2] as Triangulo
    triangulo.base
    triangulo.altura
    triangulo.nombre
    triangulo.color
}

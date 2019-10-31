import kotlin.math.PI

/**
 * El polimorfismo puede se puede aplicar de dos maneras: con clases abstractas y con interfaces
 */

fun main() {
    polimorfismoClasesAbstractas()
    polimorfismoInterfaces()
    interfacesComoEventos()
}

fun polimorfismoClasesAbstractas() {

    /**
     * Las clases abstractas se usan para generalizar entidades. Su unico proposito es proporcionar
     * una plantilla para despues implementarla en otra clase, de esta manera se ahorran muchas lineas
     * de codigo. No se puede instanciar una clase abstracta, debido a que es solo una plantilla.
     */

    // Se crea la clase general Figura2D, que representa figuras en dos dimensiones

    abstract class Figura2D {
        abstract val nombre: String
        abstract fun calcularArea(): Double
        abstract fun calcularPerimetro(): Double
    }

    /**
     * Cuando se hereda de una clase abstracta, es obligatorio implementar todos sus metodos. Asi es
     * como se logra el polimorfismo
     */

    class Cuadrado(val lado: Double) : Figura2D() {

        override val nombre: String
            get() = "Cuadrado"

        override fun calcularArea(): Double {
            return lado * lado
        }

        override fun calcularPerimetro(): Double {
            return lado * 4
        }
    }

    class Circulo(val radio: Double) : Figura2D() {

        override val nombre: String
            get() = "Circulo"

        override fun calcularArea(): Double {
            return PI * radio * radio
        }

        override fun calcularPerimetro(): Double {
            return PI * radio * 2
        }
    }

    class Rectangulo(val base: Double, val altura: Double) : Figura2D() {

        override val nombre: String
            get() = "Rectangulo"

        override fun calcularArea(): Double {
            return base * altura
        }

        override fun calcularPerimetro(): Double {
            return base + base + altura + altura
        }
    }

    /**
     * Ahora podemos hacer una coleccion de objetos de tipo Figura2D y aplicar el polimorsimo utilizando
     * la implementacion de cada instancia
     */
    val figuras = ArrayList<Figura2D>()

    figuras.add(Cuadrado(2.5))
    figuras.add(Circulo(6.18))
    figuras.add(Rectangulo(5.23, 9.64))

    for (figura in figuras) {

        // Cada figura aplica sus metodos de su propia manera, es decir, polimorficamente
        val nombre = figura.nombre
        val area = figura.calcularArea()
        val perimetro = figura.calcularPerimetro()

        println("La figura $nombre tiene el area $area y el perimetro $perimetro")
    }
}

/**
 * La otra manera de aplicar el polimorfismo es con interfaces. La ventaja de las interfaces
 * sobre las clases abstractas es que se pueden implementar la cantidad de interfaces que queramos,
 * a diferencia de clases abstractas que solo se puede implementar una.
 *
 * Tambien se pueden implementar ambas a la vez, una sola clase abstracta pero varias interfaces.
 *
 * Las interfaces solo pueden ser globales, es decir, no pueden declararse dentro de metodos
 */

interface InterfazA {
    fun metodoA()
}

interface InterfazB {
    fun metodoB()
}

interface InterfazC {
    fun metodoC()
}

class Implementaciones : InterfazA, InterfazB, InterfazC {

    override fun metodoA() {
        println("Esta es la implementacion del metodo A")
    }

    override fun metodoB() {
        println("Esta es la implementacion del metodo B")
    }

    override fun metodoC() {
        println("Esta es la implementacion del metodo C")
    }
}

fun polimorfismoInterfaces() {

    /**
     * La manera de adquirir polimorfismo con interfaces es igual que con clases abstractas, se declara
     * un objeto del tipo general, pero se instancia del tipo especifico
     */

    val interfazA : InterfazA = Implementaciones()
    interfazA.metodoA()

    val interfazB : InterfazB = Implementaciones()
    interfazB.metodoB()

    val interfazC : InterfazC = Implementaciones()
    interfazC.metodoC()

    /**
     * O tambien se puede instanciar directamente a la clase implementada
     */

    val interfaz = Implementaciones()
    interfaz.metodoA()
    interfaz.metodoB()
    interfaz.metodoC()
}

/**
 * El uso mas practico para las interfaces es utilizarlas como eventos. En ocasiones es necesario
 * realizar una accion distinta para un mismo caso, y para esto podemos utilizar interfaces
 * directamente como una instancia, en vez de implementarla en una clase.
 */

/**
 * Para este ejemplo vamos a hacer un Inventario que lleve el conteo de los productos. Cuando los
 * productos se esten agotando, hay que notificar al usuario mediante una interfaz.
 */

class Inventario {

    // Esta es la interfaz que nos va a servir como evento
    interface NotificarAgotamiento {
        fun notificar(producto: String)
    }

    // Un mapa con el conteo de los productos
    private val productos = HashMap<String, Int>()

    // Un objeto notificador
    private var notificador: NotificarAgotamiento? = null

    // Metodo para agregar un producto
    fun agregarProducto(nombre: String, cantidad: Int) {

        if (!productos.containsKey(nombre)) {
            productos[nombre] = cantidad
            return
        }

        productos[nombre] = productos[nombre]!! + cantidad
    }

    // Metodo para quitar un producto
    fun quitarProducto(nombre: String, cantidad: Int) {
        if (!productos.containsKey(nombre)) {
            return
        }

        productos[nombre] = productos[nombre]!! - cantidad

        /**
         * Aqui es donde ocurre lo interesante. Si en algun momento un producto se agota, entonces se
         * activara el evento y su usara el metodo de la interfaz mandando el nombre del producto agotado
         */
        if (productos[nombre]!! <= 0)
            notificador!!.notificar(nombre)
    }

    // Metodo para establecer la instancia del objeto evento
    fun setNotificarAgotamiento(notificador: NotificarAgotamiento) {
        this.notificador = notificador
    }
}

fun interfacesComoEventos() {

    /**
     * Ahora vamos a instanciar el inventario y agregaremos unos cuantos productos
     */

    val inventario = Inventario()

    inventario.agregarProducto("Pan", 5)
    inventario.agregarProducto("Cereal", 10)
    inventario.agregarProducto("Leche", 3)

    /**
     * Aqui es donde ponemos el evento del Inventario. Cuando un producto se agote, ocurrira lo que nosotros
     * especifiquemos dentro de la interfaz
     */
    inventario.setNotificarAgotamiento(object : Inventario.NotificarAgotamiento {
        override fun notificar(producto: String) {
            println("El producto '$producto' se esta agotando")
        }
    })

    /**
     * Quitemos algunos productos para verificar que el evento funcione
     */

    inventario.quitarProducto("Pan", 5)
    inventario.quitarProducto("Cereal", 3)
    inventario.quitarProducto("Leche", 10)
}


package Codelab5

import kotlin.math.PI
import kotlin.math.pow

// Clase base Aquarium con dimensiones y volumen calculado
open class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {

    // Constructor secundario para calcular altura según el número de peces
    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 por pez + espacio extra para que el agua no se derrame
        val tank = numberOfFish * 2000 * 1.1
        // Calcular la altura necesaria
        height = (tank / (length * width)).toInt()
    }

    // Propiedad calculada para obtener el volumen del acuario en litros
    open val volume: Int
        get() = width * height * length / 1000  // 1000 cm^3 = 1 l

    // Propiedad calculada para obtener el agua en litros
    open val water: Double
        get() = volume * 0.9

    // Método abierto para mostrar el tamaño y volumen del acuario
    open fun printSize() {
        println("rectangle") // Para acuario rectangular
        println("Width: $width cm Length: $length cm Height: $height cm")
        println("Volume: $volume l Water: $water l (${water / volume * 100.0}% full)")
    }

    // Propiedad para establecer el volumen, ajustando la altura
    // Se utiliza una propiedad privada para almacenar el valor del volumen
    private var _volume: Int = volume
    var volume: Int
        get() = _volume
        set(value) {
            _volume = value
            height = (value * 1000) / (width * length)
        }
}

// Clase TowerTank que hereda de Aquarium y redefine el cálculo del volumen
class TowerTank(height: Int, var diameter: Int) :
    Aquarium(length = diameter, width = diameter, height = height) {

    // Sobrescribir la propiedad volume para calcular el volumen como cilindro
    override val volume: Int
        get() = (PI * (diameter / 2.0).pow(2) * height / 1000).toInt()  // Convertir cm^3 a litros

    // Sobrescribir la propiedad water para el TowerTank
    override val water: Double
        get() = volume * 0.8

    // Sobrescribir el método printSize para mostrar la forma del cilindro
    override fun printSize() {
        println("cylinder")
        println("Width: $diameter cm Length: $diameter cm Height: $height cm")
        println("Volume: $volume l Water: $water l (${water / volume * 100.0}% full)")
    }
}

// Función para construir y mostrar diferentes acuarios y un TowerTank
fun buildAquarium() {
    val myAquarium = Aquarium(width = 25, length = 25, height = 40)
    myAquarium.printSize() // Muestra el acuario rectangular

    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize() // Muestra el tanque cilíndrico

    // Ejemplo adicional de ajuste del volumen
    val myAquarium2 = Aquarium(numberOfFish = 29)
    myAquarium2.printSize()
    myAquarium2.volume = 70
    myAquarium2.printSize()
}

// Enumeraciones
enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF)
}

// Clase sellada para representar focas
sealed class Seal
class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
    return when(seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}

// Interfaz para color de peces
interface FishColor {
    val color: String
}

// Objeto singleton que implementa FishColor
object GoldColor : FishColor {
    override val color = "gold"
}

// Clase de datos para decoración
data class Decoration(val rocks: String)

// Función para crear y mostrar decoraciones
fun makeDecorations() {
    val decoration1 = Decoration("granite")
    println(decoration1)

    val decoration2 = Decoration("slate")
    println(decoration2)

    val decoration3 = Decoration("slate")
    println(decoration3)
}

// Interfaz para acciones de peces
interface FishAction {
    fun eat()
}

// Clase abstracta para peces de acuario
abstract class AquariumFish : FishAction {
    abstract val color: String
    override fun eat() = println("yum")
}

// Clase de pez Shark
class Shark : AquariumFish() {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}

// Clase de pez Plecostomus
class Plecostomus(fishColor: FishColor = GoldColor) : AquariumFish(), FishColor by fishColor {
    override val color = "gold"
    override fun eat() {
        println("eat algae")
    }
}

// Función para crear y mostrar peces
fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()
    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

// Función principal para ejecutar el código
fun main() {
    buildAquarium()

    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)

    println(Color.RED.rgb)
    println(Color.GREEN.rgb)
    println(Color.BLUE.rgb)

    makeDecorations()
    makeFish()
}

// Divide peces en listas de agua dulce y salada
val twoLists = fish.partition { isFreshWater(it) }
println("freshwater: ${twoLists.first}")
println("saltwater: ${twoLists.second}")

// Crea un par con equipo y uso
val equipment = "fish net" to "catching fish"
println("${equipment.first} used for ${equipment.second}")

// Crea un trío de números
val numbers = Triple(6, 9, 42)
println(numbers.toString())
println(numbers.toList())

// Par anidado en otro par
val equipment2 = ("fish net" to "catching fish") to "equipment"
println("${equipment2.first} is ${equipment2.second}")
println("${equipment2.first.second}")

// Desestructura un par
val (tool, use) = equipment
println("$tool is used for $use")

// Desestructura un trío
val (n1, n2, n3) = numbers
println("$n1 $n2 $n3")

// Suma los elementos de una lista de números
val list = listOf(1, 5, 3, 4)
println(list.sum())

// Error al intentar sumar cadenas directamente
val list2 = listOf("a", "bbb", "cc")
println(list2.sum())

// Suma las longitudes de las cadenas
println(list2.sumBy { it.length })

// Itera sobre una lista de cadenas
for (s in list2.listIterator()) {
    println("$s ")
}

// Mapea síntomas a enfermedades de peces
val cures = hashMapOf("white spots" to "Ich", "red sores" to "hole disease")
println(cures.get("white spots"))
println(cures["red sores"])

// Manejo de claves inexistentes en un hash map
println(cures["scale loss"])
println(cures.getOrDefault("bloating", "sorry, I don't know"))
println(cures.getOrElse("bloating") { "No cure for this" })

// Modifica un mapa mutable
val inventory = mutableMapOf("fish net" to 1)
inventory.put("tank scrubber", 3)
println(inventory.toString())
inventory.remove("fish net")
println(inventory.toString())

// Define una constante de compilación
const val rocks = 3

// Asigna un valor en tiempo de ejecución
val value1 = complexFunctionCall()

// Constante dentro de un objeto singleton
object Constants {
    const val CONSTANT2 = "object constant"
}
val foo = Constants.CONSTANT2

// Clase con una constante en un companion object
class MyClass {
    companion object {
        const val CONSTANT3 = "constant in companion"
    }
}

// Extensión que verifica si una cadena tiene espacios
fun String.hasSpaces(): Boolean {
    return this.find { it == ' ' } != null
}
println("Does it have spaces?".hasSpaces())

// Versión simplificada de hasSpaces
fun String.hasSpaces() = find { it == ' ' } != null

// Clase con una propiedad privada
class AquariumPlant(val color: String, private val size: Int)

// Extensión que verifica si el color es rojo
fun AquariumPlant.isRed() = color == "red"

// Error al acceder a una propiedad privada en una extensión
// fun AquariumPlant.isBig() = size > 50 // ERROR

// Clase derivada con extensión de impresión
open class AquariumPlant(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

// Muestra el tipo de planta
val plant = GreenLeafyPlant(size = 10)
plant.print()
val aquariumPlant: AquariumPlant = plant
aquariumPlant.print()

// Propiedad de extensión que verifica si el color es verde
val AquariumPlant.isGreen: Boolean
    get() = color == "green"
println(aquariumPlant.isGreen)

// Extensión para manejar un objeto nulo
fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}
val plant: AquariumPlant? = null
plant.pull()
fun main() {
    val i: Int = 6
    val b1 = i.toByte()
    println(b1)

    val b2: Byte = 8 // OK, literals are checked statically
    println(b2)

    // A continuación, la conversión de tipo es correcta
    val i4: Int = b2.toInt()
    println(i4)

    val i5: String = b2.toString()
    println(i5)

    val i6: Double = b2.toDouble()
    println(i6)

    val oneMillion = 1_000_000
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010
    println(oneMillion)
    println(socialSecurityNumber)
    println(hexBytes)
    println(bytes)

    // Definir y asignar var
    var fish = 1
    fish = 2

    var aquarium = 1
    aquarium = 2

    var fish1: Int = 12
    var lakes: Double = 2.5

    // Cadenas
    val numberOfFish = 5
    val numberOfPlants = 12
    println("I have $numberOfFish fish and $numberOfPlants plants")

    println("I have ${numberOfFish + numberOfPlants} fish and plants")

    // Comparación de condiciones y valores booleanos
    val numberOfFish2 = 50
    val numberOfPlants2 = 23
    if (numberOfFish2 > numberOfPlants2) {
        println("Good ratio!")
    } else {
        println("Unhealthy ratio")
    }

    val fish2 = 50
    if (fish2 in 1..100) {
        println(fish2)
    }

    if (numberOfFish == 0) {
        println("Empty tank")
    } else if (numberOfFish < 40) {
        println("Got fish!")
    } else {
        println("That's a lot of fish!")
    }

    // La nulidad
    var marbles: Int? = null

    // Utilización segura de nullable types
    var fishFoodTreats = 6
    fishFoodTreats = fishFoodTreats.dec()

    println(fishFoodTreats)
    fishFoodTreats = fishFoodTreats.takeIf { it != null }?.dec() ?: 0
    println(fishFoodTreats)

    // Listas
    val school = listOf("mackerel", "trout", "halibut")
    println(school)

    val myList = mutableListOf("tuna", "salmon", "shark")
    myList.remove("shark")

    val school2 = arrayOf("shark", "salmon", "minnow")
    println(school2.joinToString(", "))

    val mix = arrayOf("fish", 2)

    val numbers = intArrayOf(1, 2, 3)
    val numbers2 = intArrayOf(1, 2, 3)
    val numbers3 = intArrayOf(4, 5, 6)
    val foo2 = numbers3 + numbers2
    println(foo2[5])

    val numbers4 = intArrayOf(1, 2, 3)
    val oceans = listOf("Atlantic", "Pacific")
    val oddList = listOf(numbers4.toList(), oceans, "salmon")
    println(oddList)

    val array = Array(5) { it * 2 }
    println(array.joinToString(", "))

    // Hacer bucles
    val school3 = arrayOf("shark", "salmon", "minnow")
    for (element in school) {
        print("$element ")
    }
    println()

    for ((index, element) in school.withIndex()) {
        println("Item at $index is $element")
    }

    for (i in 1..5) print(i)
    println()

    for (i in 5 downTo 1) print(i)
    println()

    for (i in 3..6 step 2) print(i)
    println()

    for (i in 'd'..'g') print(i)
    println()

    var bubbles = 0
    while (bubbles < 50) {
        bubbles++
    }
    println("$bubbles bubbles in the water")

    do {
        bubbles--
    } while (bubbles > 50)
    println("$bubbles bubbles in the water")

    repeat(2) {
        println("A fish is swimming")
    }
}

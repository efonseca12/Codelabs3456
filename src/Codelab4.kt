import java.util.*

fun main(args: Array<String>) {
    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)

    val temperature1 = 10
    val message = "The water temperature is ${if (temperature1 > 50) "too warm" else "OK"}."
    println(message)

    feedTheFish()

    swim()   // uses default speed
    swim("slow")   // positional argument
    swim(speed = "turtle-like")   // named parameter

    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    println(decorations)
    println( decorations.filter {it[0] == 'p'})



    val eager = decorations.filter { it [0] == 'p' }
    println("eager: $eager")

    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")

    val newList = filtered.toList()
    println("new list: $newList")


    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }

    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")

    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")

    var dirtyLevel = 20
    val waterFilter = { dirty : Int -> dirty / 2}
    println(waterFilter(dirtyLevel))

    val waterFilter2: (Int) -> Int = { dirty -> dirty / 2 }
    println(waterFilter2(dirtyLevel))

    val waterFilter3: (Int) -> Int = { dirty -> dirty / 2 }
    println(updateDirty(30, waterFilter3))

    fun increaseDirty( start: Int ) = start + 1

    println(updateDirty(15, ::increaseDirty))

    var dirtyLevel2 = 19;
    dirtyLevel2 = updateDirty(dirtyLevel2) { dirtyLevel2 -> dirtyLevel2 + 23}
    println(dirtyLevel2)


    }















fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}
fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun randomDay(): String {
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

fun swim(speed: String = "fast") {
    println("Swimming $speed")
}

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

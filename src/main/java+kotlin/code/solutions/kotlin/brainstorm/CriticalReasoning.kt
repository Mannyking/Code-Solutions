package code.solutions.kotlin.brainstorm

fun main() {
    println(CriticalReasoning().calculateYears(53).contentToString())
}

class CriticalReasoning {
// A hero is on his way to the castle to complete his mission.
// However, he's been told that the castle is surrounded with a couple of powerful dragons! each dragon takes 2 bullets to be defeated,
// Assuming he's gonna grab a specific given number of bullets and move forward to fight another specific given number of dragons, will he survive?
    fun hero(bullets: Int, dragons: Int) : Boolean = ((bullets / 2) >= dragons)

// Return their respective ages now as [humanYears,catYears,dogYears]
    fun calculateYears(years: Int): Array<Int> {
        var catYears = 0
        var dogYears = 0

        val firstYear = 15
        val secondYear = 9
        val subsequentYearsDog = 5
        val subsequentYearsCat = 4

        for (i in years downTo 1) {
            println("Year $i")
            when (i) {
                1 -> {
                    catYears += firstYear
                    dogYears += firstYear
                }
                2 -> {
                    catYears += secondYear
                    dogYears += secondYear
                }
                else -> {
                    catYears += subsequentYearsCat
                    dogYears += subsequentYearsDog
                }
            }
        }
        return arrayOf(years, catYears, dogYears);
    }
}
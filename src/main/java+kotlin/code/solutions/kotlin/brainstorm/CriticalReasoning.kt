package code.solutions.kotlin.brainstorm

import kotlin.math.pow

fun main() {
    println(CriticalReasoning().moveTen("pestcase"))
}

class CriticalReasoning {
    // Move every letter in the provided string forward 10 letters through the alphabet.
    // If it goes past 'z', start again at 'a'.
    fun moveTen(s: String): String {
        val CHAR_FIRST = 'a'.code
        val CHAR_LAST = 'z'.code

        val list = s.lowercase().map { char ->
            var value = char.code + 10
            if (value > CHAR_LAST) {
                value = (value - CHAR_LAST - 1) + CHAR_FIRST
            }
            value.toChar()
        }

        return list.joinToString("")
    }

    companion object Rainfall {
        private fun parseTownData(town: String, strng: String): List<Double> {
            return strng
                .lineSequence()
                .find { it.startsWith("$town:") }
                ?.let { Regex("\\d+(\\.\\d+)?").findAll(it).map { match -> match.value.toDouble() }.toList() }
                ?: emptyList()
        }

        fun mean(town: String, strng: String): Double {
            val data = parseTownData(town, strng)
            return if (data.isNotEmpty()) data.average() else -1.0
        }

        fun variance(town: String, strng: String): Double {
            val data = parseTownData(town, strng)
            if (data.isEmpty()) return Double.NaN

            val mean = data.average()
            return data.sumOf { (it - mean).pow(2) } / data.size
        }
    }

    // Write two functions, one that converts standard time to decimal time and one that converts decimal time to standard time.
//
//One hour has 100 minutes (or 10,000 seconds) in decimal time, yet its duration is the same as in standard time. Thus, a decimal minute consists of 36 standard seconds, which is 1/100 of an hour.
//Working time is usually rounded to integer decimal minutes. Thus, one standard minute equals 0.02 decimal hours, while two standard minutes equal 0.03 decimal hours and so on.
//The terms "normal" and "standard" time are considered synonymous in this kata, just like the terms "decimal" and "industrial" time.
//toIndustrial(time) should accept either the time in minutes as an integer or a string of the format "h:mm". Minutes will always consist of two digits in the tests (e.g., "0:05"); hours can have more. Return a double that represents decimal hours (e.g. 1.75 for 1h 45m). Round to a precision of two decimal digits - do not simply truncate!
//toNormal(time) should accept a double representing decimal time in hours. Return a string that represents standard time in the format "h:mm".
//There will be no seconds in the tests. We'll neglect them for the purpose of this kata.
    fun toIndustrial(t: Int): Double {
        return Math.round(t / 0.6) / 100.0
    }

    fun toIndustrial(t: String): Double {
        val (h, m) = t.split(":").map { it.toInt() }
        return toIndustrial(h * 60 + m)
    }

    fun toNormal(t: Double): String {
        val tm = Math.round(t * 60)
        val h = tm / 60
        val m = (tm % 60).toString().padStart(2, '0')
        return "${h}:${m}"
    }

    // A hero is on his way to the castle to complete his mission.
// However, he's been told that the castle is surrounded with a couple of powerful dragons! each dragon takes 2 bullets to be defeated,
// Assuming he's gonna grab a specific given number of bullets and move forward to fight another specific given number of dragons, will he survive?
    fun hero(bullets: Int, dragons: Int): Boolean = ((bullets / 2) >= dragons)

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
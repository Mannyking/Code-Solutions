package code.solutions.kotlin.brainstorm

import kotlin.math.pow

var data = (
        "Rome:Jan 81.2,Feb 63.2,Mar 70.3,Apr 55.7,May 53.0,Jun 36.4,Jul 17.5,Aug 27.5,Sep 60.9,Oct 117.7,Nov 111.0,Dec 97.9" +
                "\n" +
                "London:Jan 48.0,Feb 38.9,Mar 39.9,Apr 42.2,May 47.3,Jun 52.1,Jul 59.5,Aug 57.2,Sep 55.4,Oct 62.0,Nov 59.0,Dec 52.9" +
                "\n" +
                "Paris:Jan 182.3,Feb 120.6,Mar 158.1,Apr 204.9,May 323.1,Jun 300.5,Jul 236.8,Aug 192.9,Sep 66.3,Oct 63.3,Nov 83.2,Dec 154.7" +
                "\n" +
                "NY:Jan 108.7,Feb 101.8,Mar 131.9,Apr 93.5,May 98.8,Jun 93.6,Jul 102.2,Aug 131.8,Sep 92.0,Oct 82.3,Nov 107.8,Dec 94.2" +
                "\n" +
                "Vancouver:Jan 145.7,Feb 121.4,Mar 102.3,Apr 69.2,May 55.8,Jun 47.1,Jul 31.3,Aug 37.0,Sep 59.6,Oct 116.3,Nov 154.6,Dec 171.5" +
                "\n" +
                "Sydney:Jan 103.4,Feb 111.0,Mar 131.3,Apr 129.7,May 123.0,Jun 129.2,Jul 102.8,Aug 80.3,Sep 69.3,Oct 82.6,Nov 81.4,Dec 78.2" +
                "\n" +
                "Bangkok:Jan 10.6,Feb 28.2,Mar 30.7,Apr 71.8,May 189.4,Jun 151.7,Jul 158.2,Aug 187.0,Sep 319.9,Oct 230.8,Nov 57.3,Dec 9.4" +
                "\n" +
                "Tokyo:Jan 49.9,Feb 71.5,Mar 106.4,Apr 129.2,May 144.0,Jun 176.0,Jul 135.6,Aug 148.5,Sep 216.4,Oct 194.1,Nov 95.6,Dec 54.4" +
                "\n" +
                "Beijing:Jan 3.9,Feb 4.7,Mar 8.2,Apr 18.4,May 33.0,Jun 78.1,Jul 224.3,Aug 170.0,Sep 58.4,Oct 18.0,Nov 9.3,Dec 2.7" +
                "\n" +
                "Lima:Jan 1.2,Feb 0.9,Mar 0.7,Apr 0.4,May 0.6,Jun 1.8,Jul 4.4,Aug 3.1,Sep 3.3,Oct 1.7,Nov 0.5,Dec 0.7")

fun main() {
    println(CriticalReasoning.mean("London", data))
}

class CriticalReasoning {
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
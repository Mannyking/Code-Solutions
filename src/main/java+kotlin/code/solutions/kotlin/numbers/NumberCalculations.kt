package code.solutions.kotlin.numbers

import kotlin.math.pow
import kotlin.math.sqrt

class NumberCalculations {
    fun bmi(weight: Double, height: Double): String {
        // TODO: add your solution here
        val bmi = weight / (height.pow(2)).toInt()
        return when {
            bmi <= 18.5  -> "Underweight"
            bmi <= 32 -> "ummm"
            else -> "uhhh"
        };
    }

// You are given two arrays a1 and a2 of strings. Each string is composed with letters from a to z.
// Let x be any string in the first array and y be any string in the second array.
// Find max(abs(length(x) − length(y)))
    fun mxdiflg(a1: Array<String>, a2: Array<String>): Int {
        return Math.abs(a1.size - a2.size)
    }

    // We know the content of the evaporator (content in ml), the percentage of foam or gas lost every day (evap_per_day)
// and the threshold (threshold) in percentage beyond which the evaporator is no longer useful. All numbers are strictly positive.
// The program reports the nth day (as an integer) on which the evaporator will be out of use.
    fun evaporator(content: Double, evap_per_day: Double, threshold: Double): Int {
        var days = 0
        var _content = content
        val expiration = content * (threshold / 100)
        val contentLostPerDay = 1 - (evap_per_day / 100)
        while (_content >= expiration) {
            days++
            _content *= contentLostPerDay
        }
        return days
    }

    // Write a program that finds the summation of every number from 1 to num
    fun summation(num: Int): Int {
        if (num > 0) {
            return num + summation(num - 1)
        }
        return 0
    }

    // Given three integers a ,b ,c, return the largest number obtained after inserting the following operators and brackets: +, *, ()
    fun expressionsMatter(a: Int, b: Int, c: Int): Int {
        val first = a * b * c
        val second = a * b + c
        val third = (a + b) * c
        val fourth = a + b + c
        val fifth = a * (b + c)
        return listOf(first, second, third, fifth, fourth).max()
    }

    // function that takes varying number of arguments
    fun addNumbers(vararg numbers: Int): Int {
        var result = 0
        for (number in numbers) {
            result += number
        }
        result /= numbers.size
        println("The size of vararg numbers is ${numbers.size}")
        return result
    }

    fun alternatingSum(vararg numbers: Int) {
        if (numbers.isEmpty()) return

        var result = numbers[0]
        for (num in 1 until numbers.size) {
            println("Index: $num")
            println("Result is currently $result")
            result = if (num % 2 == 1) {
                result - numbers[num]
            } else {
                result + numbers[num]
            }
        }
        println("Final Result: $result")
    }

    // Take a list of ages when each of your great-grandparent died.
//Multiply each number by itself.
//Add them all together.
//Take the square root of the result.
//Divide by two.
    fun predictAge(vararg age: Int): Int {
        val squared = age.map { it * it }
        val added = squared.sum()
        val rooted = sqrt(added.toDouble()).toInt()
        println("The final result is ${rooted / 2}")
        return rooted / 2
    }

    // remove the last digit until you're left with a number that is a multiple of three.
// Return n if the input is already a multiple of three
    fun prevMultOfThree(n: Int): Int? {
        if (n % 3 == 0) return n
        var newNumber = n
        val len = n.toString().length
        for (i in 1..len) {
            newNumber /= 10
            println(newNumber)
            if (newNumber % 3 == 0 && newNumber != 0) return newNumber
        }
        return null
    }

}

fun main() {
    val numberCalculations = NumberCalculations()
    println(numberCalculations.evaporator(10.0, 10.0, 10.0))
}

package code.solutions.kotlin.numbers

import kotlin.math.sqrt

fun main() {
    val triangle = Triangle(4.9, 5.5, 6.0)
    println("The area of the triangle is ${triangle.area()}")
    println("The perimeter of the triangle is ${triangle.perimeter()}")
}

class NumberCalculations {
// Write a program that finds the summation of every number from 1 to num
    fun summation(num: Int): Int {
        if (num > 0) {
            return num + summation(num-1)
        }
        return 0
    }

// Given three integers a ,b ,c, return the largest number obtained after inserting the following operators and brackets: +, *, ()
    fun expressionsMatter(a : Int, b : Int, c : Int): Int {
        val first = a * b * c
        val second = a * b + c
        val third = (a + b) * c
        val fourth = a + b + c
        val fifth = a * (b + c)
        return listOf(first, second, third, fifth, fourth).max()
    }

    fun alternatingSum(vararg numbers: Int) {
        if (numbers.isEmpty()) return

        var result = numbers[0]
        for (num in 1 until numbers.size) {
            println("Index: $num")
            println("Result is currently $result")
            result = if (num % 2 == 1) {
                result - numbers[num]
            }
            else {
                result + numbers[num]
            }
        }
        println("Final Result: $result")
    }
}


class Triangle(
    private val x: Double,
    private val y: Double,
    private val z: Double
) {
    init {
        println("We will now be performing some series of operations on this Triangle, values are $x, $y, and $z")
    }

    fun area(): Double {
        val perimeterHalf = perimeter() / 2
        return sqrt(perimeterHalf * (perimeterHalf-x) * (perimeterHalf-y) * (perimeterHalf-z))
    }

    fun perimeter() = x + y + z
}

fun MutableList<Int>.product(): Int {
    var result = 1
    for (i in this) {
        result *= i
    }
    return result
}
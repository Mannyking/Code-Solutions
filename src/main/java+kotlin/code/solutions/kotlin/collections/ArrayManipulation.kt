package code.solutions.kotlin.collections

//Given a non-empty array of integers, return the result of multiplying the values together in order. Example:
//
//[1, 2, 3, 4] => 1 * 2 * 3 * 4 = 24
fun main() {
    val arrayManipulation = ArrayManipulation()

    println("Enter 5 numbers:")
    val first = readlnOrNull()
    val second = readlnOrNull()
    val third = readlnOrNull()
    val fourth = readlnOrNull()
    val fifth = readlnOrNull()

    if (first != null && second != null && third != null && fourth != null && fifth != null) {
        println(addNumbers(first.toInt(), second.toInt(), third.toInt(), fourth.toInt(), fifth.toInt()))
    }
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

class ArrayManipulation {
    fun grow(arr: IntArray): Int {
        var result = 1
        for (i in arr.indices) {
            result *= arr[i]
        }
        return result
    }

    fun printArray() {
        val arr = arrayOf(1, 2, 3, 4, "man")
        for (i in arr.indices) {
            println(arr[i])
        }
    }
}
package code.solutions.kotlin.collections

fun main() {
    val listManipulation = ListManipulation()
    listManipulation.evenNumbers(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 3)
}

class ListManipulation {
// Given an array of numbers, return a new array of length number containing the last even numbers from the original array (in the same order).
// The original array will be not empty and will contain at least "number" even numbers.
    fun evenNumbers(list: List<Int>, number: Int): List<Int> {
        var newList: List<Int> = listOf()
        if (list.size > number) {
            val difference = list.size - number
            newList = list.filterIndexed { index, value -> (index >= difference && value % 2 == 0) }
        }
        return newList
    }

    //fibonacci series
    fun calcFibonacci(length: Int): MutableList<Int> {
        val list = mutableListOf(0, 1)

        for ((counter, _) in (1..length - 2).withIndex()) {
            list.add(list[counter] + list[counter + 1])
        }
        return list
    }

// Create a method that accepts a list and an item, and returns true if the item belongs to the list, otherwise false.
    fun include(arr: IntArray, item : Int): Boolean {
        return arr.contains(item)
    }


}

fun findIndex(list: List<Int>, number: Int) {
    var result : Int
    for (item in list.indices) {
        if (number == list[item]) println("$number exists at index $item")
    }
}

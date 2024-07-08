package code.solutions.kotlin.collections

fun main() {
    val listManipulation = ListManipulation()
    findIndex(listOf(2, 4, 5, 3, 1, 10), 4)
}

class ListManipulation {
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

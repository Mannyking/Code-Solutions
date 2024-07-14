package code.solutions.kotlin.collections

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

// Given a random non-negative number, you have to return the digits of this number within an array in reverse order.
    fun digitize(n: Long): IntArray {
        val str = n.toString().reversed()
        val list: MutableList<Int> = mutableListOf()
        for (s in str) {
            list.add(s.digitToInt())
        }
        return list.toIntArray()
    }

// You are provided with a list (or array) of integer pairs.
// Elements of each pair represent the number of people that get on the bus (the first item) and the number of people that get off the bus (the second item) at a bus stop.
// Your task is to return the number of people who are still on the bus after the last bus stop (after the last array)
    fun people(busStops: Array<Pair<Int, Int>>) : Int {
        var peopleWhoLeft = 0
        var maxPeopleOnboard = 0
        var remainingPeople = 0
        for (pair in busStops) {
            maxPeopleOnboard = pair.first
            peopleWhoLeft = pair.second
            remainingPeople += (maxPeopleOnboard - peopleWhoLeft)
        }
    return remainingPeople
    }
}

fun main() {
    val arrayManipulation = ArrayManipulation()
    arrayManipulation.digitize(3212423)
}

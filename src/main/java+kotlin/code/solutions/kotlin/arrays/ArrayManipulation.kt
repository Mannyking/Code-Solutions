package code.solutions.kotlin.arrays

//Given a non-empty array of integers, return the result of multiplying the values together in order. Example:
//
//[1, 2, 3, 4] => 1 * 2 * 3 * 4 = 24
fun main() {
    println(grow(intArrayOf(2, 2, 3, 4))) // 24
}

fun grow(arr: IntArray): Int {
    var result = 1
    for (i in arr.indices) {
        result *= arr[i]
    }
    return result
}
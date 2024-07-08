package code.solutions.kotlin.strings

import java.util.*

class StringManipulation {
//    Replace all vowel to exclamation mark in the sentence. aeiouAEIOU is vowel.
    fun replace(s: String): String {
        val sArray = s.toCharArray()
        for (i in sArray.indices) {
            when (sArray[i]) {
                'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> sArray[i] = '!'
            }
        }
        return String(sArray)
    }

    //copilot version
    fun replace2(s: String): String {
        return s.replace("[aeiouAEIOU]".toRegex(), "!")
    }

// Get ASCII value of a character.
    fun getAscii(c: Char): Int = c.code

// Write a function that accepts an integer n and a string s as parameters, and returns a string of s repeated exactly n times.
    fun repeatStr(r: Int, str: String) : String {
        var result = ""
        for (n in 0 until r) {
            result += str
        }
    return result
    }
}

fun main() {
    val stringManipulation = StringManipulation()
    println(stringManipulation.repeatStr(5, "mannan"))
}
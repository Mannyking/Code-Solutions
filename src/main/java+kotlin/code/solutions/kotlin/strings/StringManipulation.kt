package code.solutions.kotlin.strings

import java.util.*

class StringManipulation {
// jdbc:mysql://sdasdasdasd:szdasdasd:dfsdfsdfsdf/sdfsdfsdf?user=root&password=12345
    fun hidePasswordFromConnection(urlString: String): String {
        val remainder = urlString.replaceBefore("password=", "")
        val passwordLength = remainder.replaceFirst("password=", "").length
        val asterisk = "*".repeat(passwordLength)
        return urlString.replaceAfter("password=", asterisk)
    }

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

// given a string of space separated numbers, return the highest and lowest number without lambda
    fun highAndLow(numbers: String): String {
        val numList = numbers.split(" ").map { it.toInt() }
        val max = numList.maxOrNull()
        val min = numList.minOrNull()

        return "$max $min"
    }

// Given a string, capitalize the letters that occupy even indexes and odd indexes separately, and return as shown below. Index 0 will be considered even.
    fun capitalize(text: String): List<String> {
        fun even(text: String): String {
            val list: MutableList<Char> = text.toCharArray().toMutableList()
            for (i in list.indices) {
                if (i % 2 == 0) {
                    list[i] = list[i].uppercaseChar()
                }
            }
            return list.joinToString(separator = "")
        }

        fun odd(text: String): String {
            val list: MutableList<Char> = text.toCharArray().toMutableList()
            for (i in list.indices) {
                if (i % 2 == 1) {
                    list[i] = list[i].uppercaseChar()
                }
            }
            return (list.joinToString(separator = ""))
        }
        return listOf(even(text), odd(text))
    }

// accum("abcd") -> "A-Bb-Ccc-Dddd"
    fun accum(s: String): String {
        val result = StringBuilder()
        val splitList = s.toCharArray().toList()
        for ((i, v) in splitList.withIndex()) {
            result.append(v.uppercaseChar())
            repeat(i) { result.append(v.lowercaseChar()) }
            if (i != splitList.size-1) result.append("-")
        }
        return result.toString()
    }

    fun getMiddle(word : String) : String {
        val middle = word.length / 2
        if (word.length % 2 == 0) {
            return word[middle-1].toString() + word[middle].toString()
        }
        return word[middle].toString()
    }

// Change any instance of "Fire" into "~~".
    fun fireFight(s: String): String {
        return s.split(" ").joinToString(", ") { it.replace("fire", "~~", ignoreCase = true) }
    }

// 56789 -> 67895 -> 68957 -> 68579 -> 68597 and return the greatest: 68957.
    fun maxRot(n: Long): Long {
        val nStr = n.toString()
        val list: MutableList<Long> = mutableListOf(n)
        var tempStr = nStr
        for (i in 0 until nStr.length - 1) {
            println("First substring: ${tempStr.substring(0, i)}")
            println("Second substring: ${tempStr.substring(i + 1)}")
            println("Current character: ${tempStr[i]} \n")

            tempStr = tempStr.substring(0, i) + tempStr.substring(i + 1) + tempStr[i]
            list.add(tempStr.toLong())
        }
        return list.maxOrNull() ?: n
    }

// ...returning them as a string of comma-separated sequences sorted alphabetically,
// with each sequence starting with an uppercase character followed by n-1 lowercase characters,
// where n is the letter's alphabet position 1-26
    fun alphaSeq(str: String): String {
        val orderedList: MutableList<Int> = mutableListOf()
        for (i in str) {
            orderedList.add(i.lowercaseChar().code)
            orderedList.sort()
        }
        val orderedStr : String = orderedList.joinToString("") { it.toChar().toString() }

        val list = orderedStr.toCharArray().toMutableList()
        val result = StringBuilder()
        var position: Int
        for (v in list) {
            position = v.code - 'a'.code + 1
            result.append(v.uppercaseChar())
            repeat(position - 1) {result.append(v)}
            result.append(",")
        }
        println(result)
        return result.substring(0, result.length - 1).toString()
    }
}

fun main() {
    val result =
        StringManipulation().hidePasswordFromConnection("// jdbc:mysql://sdasdasdasd:szdasdasd:dfsdfsdfsdf/sdfsdfsdf?user=root&password=password=")

    println(result)
}

package code.solutions.kotlin.json

import com.google.gson.JsonObject
class GsonLibrary {
    fun createJsonObject() {
        val jsonObject = JsonObject()
        jsonObject.addProperty("name", "John Doe")
        jsonObject.addProperty("class", "A")
        jsonObject.addProperty("height", 1.86)
        jsonObject.addProperty("race", "Nigerian")
        println(jsonObject)
        print(5)

        val jsonObject2 = JsonObject()
        jsonObject2.add("json object", jsonObject)
        println(jsonObject2)
    }
}

fun loop() {
    var i = 0
    while (i < 5) {
        println("first $i")
        ++i
        println("second $i")
    }
}

fun main() {
    val instance = GsonLibrary()
    instance.createJsonObject()

    loop()
}


//first 0
//second 1
//first 1
//second 2
//first 2
//second 3
//first 3
//second 4
//first 4
//second 5
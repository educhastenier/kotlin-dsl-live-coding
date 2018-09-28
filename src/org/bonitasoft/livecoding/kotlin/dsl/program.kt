package org.bonitasoft.livecoding.kotlin.dsl


fun callFunctionOnString(myFunction: () -> Unit) {
    myFunction()
}


fun main(args: Array<String>) {
    callFunctionOnString {
        println("Live Coding")
    }
}


//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//fun callFunctionOnString(message: String, maFonction: (obj: String) -> Int): Int = maFonction(message)
//
//
//fun main(args: Array<String>) {
//    val returnCode = callFunctionOnString("coucou") { message ->
//        println(message)
//        0
//    }
//
//    println(returnCode)
//}

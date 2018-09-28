package org.bonitasoft.livecoding.kotlin.dsl


fun callFunctionOnString(message: String, maFunction: (msg: String) -> Unit) {
    maFunction(message)
}


fun main(args: Array<String>) {

    callFunctionOnString("Live Coding", { s -> println("malambda: $s") })

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

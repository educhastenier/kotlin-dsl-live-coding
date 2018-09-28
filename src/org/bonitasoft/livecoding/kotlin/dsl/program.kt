package org.bonitasoft.livecoding.kotlin.dsl


fun callFunctionOnString(maFunction: () -> Unit) = maFunction()


fun main(args: Array<String>) {

    callFunctionOnString({
        println("Live coding")
    })


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

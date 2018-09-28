package org.bonitasoft.livecoding.kotlin.dsl


fun main(args: Array<String>) {

    html {
        head { }
    }

}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}

class HTML {
    fun head(init: () -> Unit): Head {

    }
}

class Head {

}


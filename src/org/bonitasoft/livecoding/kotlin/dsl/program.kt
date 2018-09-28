package org.bonitasoft.livecoding.kotlin.dsl


fun main(args: Array<String>) {

    html {
        head {
            title {
                "This is my title"
            }
        }
    }

}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}

class HTML {
    fun head(init: Head.() -> Unit): Head {
        val head = Head()
        head.init()
        return head
    }
}

class Head {
    fun title(init: Title.() -> Unit): Title {
        val title = Title()
        title.init()
        return title
    }
}

class Title {

}


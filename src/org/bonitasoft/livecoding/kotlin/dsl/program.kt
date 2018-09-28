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

abstract class Tag {

    fun <T : Tag> initTag(tag: T, init: T.() -> Unit): T {
        tag.init()
        return tag
    }
}

class HTML: Tag() {

    fun head(init: Head.() -> Unit): Head {
        val head = Head()
        initTag(head, init)
        return head
    }

}

class Head: Tag() {
    fun title(init: Title.() -> Unit): Title {
        val title = Title()
        title.init()
        return title
    }
}

class Title: Tag() {

}


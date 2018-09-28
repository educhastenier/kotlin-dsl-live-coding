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

abstract class Tag(name: String) {

    val children = arrayListOf<Tag>()

    fun <T : Tag> initTag(tag: T, init: T.() -> Unit): T {
        tag.init()
        children.add(tag)
        return tag
    }
}

class HTML: Tag("html") {

    fun head(init: Head.() -> Unit): Head {
        val head = Head()
        initTag(head, init)
        return head
    }

}

class Head: Tag("head") {
    fun title(init: Title.() -> Unit): Title {
        val title = Title()
        title.init()
        return title
    }
}

class Title(name: String): Tag(name) {

}


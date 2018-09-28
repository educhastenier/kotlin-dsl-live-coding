package org.bonitasoft.livecoding.kotlin.dsl


fun main(args: Array<String>) {

    val page = html {
        head {
            title {
                +"This is my title"
            }
        }
    }

    println(page)

}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}

interface Renderable {
    fun render(builder: StringBuilder, indentation: String)
}

abstract class Tag(val name: String) : Renderable {

    val children = arrayListOf<Renderable>()

    fun <T : Tag> initTag(tag: T, init: T.() -> Unit): T {
        tag.init()
        children.add(tag)
        return tag
    }

    override fun render(builder: StringBuilder, indentation: String) {
        builder.append("$indentation<$name>\n")
        for (child in children) {
            child.render(builder, indentation + "  ")
        }
        builder.append("$indentation</$name>\n")
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }
}

class HTML: Tag("html") {
    fun head(init: Head.() -> Unit): Head = initTag(Head(), init)
}

class Head: Tag("head") {
    fun title(init: Title.() -> Unit): Title = initTag(Title(), init)
}

class TextElement(val text: String) : Renderable {
    override fun render(builder: StringBuilder, indentation: String) {
        builder.append("$indentation$text\n")
    }
}

abstract class TagWithText(name: String) : Tag(name) {
    operator fun String.unaryPlus() {
        children.add(TextElement(this))
    }
}

class Title : TagWithText("title") {

}


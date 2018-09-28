package org.bonitasoft.livecoding.kotlin.dsl


fun main(args: Array<String>) {

    val page =


            html {
                head {
                    title {
                        +"This is my title"
                    }
                }
                body {
                    p {
                        +"A detailed paragraph"
                    }
                    b { +"du Gras" }
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
            child.render(builder, "$indentation  ")
        }
        builder.append("$indentation</$name>\n")
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }
}

class HTML : Tag("html") {
    fun head(init: Head.() -> Unit): Head = initTag(Head(), init)
    fun body(init: Body.() -> Unit): Body = initTag(Body(), init)
}

class Head : Tag("head") {
    fun title(init: Title.() -> Unit): Title = initTag(Title(), init)
}

class Body : Tag("body") {
    fun p(init: P.() -> Unit): P = initTag(P(), init)
    fun b(init: B.() -> Unit): B = initTag(B(), init)
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

class Title : TagWithText("title")

class P : TagWithText("p")

class B : TagWithText("b")

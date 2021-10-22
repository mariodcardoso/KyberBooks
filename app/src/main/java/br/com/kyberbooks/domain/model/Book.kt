package br.com.kyberbooks.domain.model

data class Book(
    var isbn: MutableList<Isbn> = mutableListOf(Isbn("", "")),
    var title: String = "",
    var subtitle: String = "",
    var language: String = "",
    var authors: String = "",
    var publisher: String = "",
    var publishDate: String = "",
    var edition: String = "",
    var pages: String = "",
    var description: String = "",
    var tag: String = "",
    var cover: String = ""
)

data class Isbn(
    var isbn10: String = "",
    var isbn13: String = ""
)

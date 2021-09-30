package br.com.kyberbooks.data

import br.com.kyberbooks.domain.model.Book

interface BookDataSource {

    suspend fun createBook(book: Book): Book

    suspend fun getBook(isbn: String): Book

    suspend fun uploadBookCover(uri: String): String

}
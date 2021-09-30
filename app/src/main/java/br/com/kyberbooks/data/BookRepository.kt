package br.com.kyberbooks.data

import br.com.kyberbooks.domain.model.Book
import javax.inject.Inject

class BookRepository @Inject constructor(private val dataSource: BookDataSource) {

    suspend fun createBook(book: Book) = dataSource.createBook(book)

    suspend fun getBook(isbn: String) = dataSource.getBook(isbn)

    suspend fun uploadBookCover(uri: String) = dataSource.uploadBookCover(uri)

}
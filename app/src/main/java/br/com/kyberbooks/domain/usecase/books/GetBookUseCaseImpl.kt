package br.com.kyberbooks.domain.usecase.books

import br.com.kyberbooks.data.BookRepository
import br.com.kyberbooks.domain.model.Book
import javax.inject.Inject

class GetBookUseCaseImpl @Inject constructor(private val bookRepository: BookRepository) : GetBookUseCase {

    override suspend fun invoke(isbn: String): Book = bookRepository.getBook(isbn)
}
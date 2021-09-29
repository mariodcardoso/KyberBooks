package br.com.kyberbooks.domain.usecase.books

import br.com.kyberbooks.data.BookRepository
import br.com.kyberbooks.domain.model.Book
import javax.inject.Inject

class CreateBookUseCaseImpl @Inject constructor(
    private val repository: BookRepository
) : CreateBookUseCase {

    override suspend fun invoke(book: Book): Book {
        repository.createBook(book)
        return book
    }

}
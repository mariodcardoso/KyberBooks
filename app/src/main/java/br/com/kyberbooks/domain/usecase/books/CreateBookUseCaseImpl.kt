package br.com.kyberbooks.domain.usecase.books

import br.com.kyberbooks.data.BookRepository
import br.com.kyberbooks.domain.model.Book
import javax.inject.Inject

class CreateBookUseCaseImpl @Inject constructor(
    private val repository: BookRepository,
    private val uploadBookCover: UploadBookCoverUseCase
) : CreateBookUseCase {

    override suspend fun invoke(book: Book): Book {
        uploadBookCover(book.cover)
        repository.createBook(book)
        return book
    }
}
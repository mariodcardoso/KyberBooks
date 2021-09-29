package br.com.kyberbooks.domain.usecase.books

import br.com.kyberbooks.domain.model.Book

interface GetBookUseCase {
    suspend operator fun invoke(isbn: String): Book
}
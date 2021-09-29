package br.com.kyberbooks.domain.usecase.books

import br.com.kyberbooks.domain.model.Book

interface CreateBookUseCase {

    suspend operator fun invoke(book: Book): Book

}
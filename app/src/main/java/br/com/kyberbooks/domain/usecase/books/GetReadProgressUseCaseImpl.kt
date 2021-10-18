package br.com.kyberbooks.domain.usecase.books

import br.com.kyberbooks.data.BookRepository
import javax.inject.Inject

class GetReadProgressUseCaseImpl @Inject constructor(
    private val bookRepository: BookRepository
) : GetReadProgressUseCase {

    override suspend fun invoke() = bookRepository.getBookProgress()

}
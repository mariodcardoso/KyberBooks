package br.com.kyberbooks.domain.usecase.books

import br.com.kyberbooks.data.BookRepository
import javax.inject.Inject

class UploadBookCoverUseCaseImpl @Inject constructor(private val bookRepository: BookRepository) : UploadBookCoverUseCase {

    override suspend fun invoke(uri: String): String = bookRepository.uploadBookCover(uri)

}
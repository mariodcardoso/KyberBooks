package br.com.kyberbooks.domain.usecase.books

interface UploadBookCoverUseCase {

    suspend operator fun invoke(uri: String): String
}
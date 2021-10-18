package br.com.kyberbooks.domain.usecase.books

import br.com.kyberbooks.domain.model.BookReadProgress

interface GetReadProgressUseCase {
    suspend operator fun invoke(): BookReadProgress

}
package br.com.kyberbooks.domain.usecase.di

import br.com.kyberbooks.domain.usecase.books.CreateBookUseCase
import br.com.kyberbooks.domain.usecase.books.CreateBookUseCaseImpl
import br.com.kyberbooks.domain.usecase.books.GetBookUseCase
import br.com.kyberbooks.domain.usecase.books.GetBookUseCaseImpl
import br.com.kyberbooks.domain.usecase.books.GetReadProgressUseCase
import br.com.kyberbooks.domain.usecase.books.GetReadProgressUseCaseImpl
import br.com.kyberbooks.domain.usecase.books.UploadBookCoverUseCase
import br.com.kyberbooks.domain.usecase.books.UploadBookCoverUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    fun bindCreateBookUseCase(useCase: CreateBookUseCaseImpl): CreateBookUseCase

    @Binds
    fun bindGetBookUseCase(useCase: GetBookUseCaseImpl): GetBookUseCase

    @Binds
    fun bindUploadBookCoverUseCase(useCase: UploadBookCoverUseCaseImpl): UploadBookCoverUseCase

    @Binds
    fun bindGetReadProgressUseCase(useCase: GetReadProgressUseCaseImpl): GetReadProgressUseCase
}